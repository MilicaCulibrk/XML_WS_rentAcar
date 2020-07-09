package agentBackend.service;


import agentBackend.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import agentBackend.model.Addvertisment;
import agentBackend.model.Comment;
import agentBackend.model.Grade;
import agentBackend.model.Image;
import agentBackend.model.ReservedDate;
import agentBackend.repository.*;
import agentBackend.wsdl.Add;

import java.awt.*;


@Service
public class AddvertismentService {

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Autowired
    private TransmissionTypeRepository transmissionTypeRepository;

    @Autowired
    private VehicleClassRepository vehicleClassRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ReservedDateRepository reservedDateRepository;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public List<AddvertismentDTO> getAllAdds() {
        List<AddvertismentDTO> addsDTOlist = new ArrayList<>();
        List<Addvertisment> adds = addvertismentRepository.findAll();
        for (Addvertisment add : adds) {
            addsDTOlist.add(new AddvertismentDTO(add));
        }
        return addsDTOlist;
    }

    public List<AddvertismentDisplayDTO> getAllUsersAddvertisments(String username) {
        List<AddvertismentDisplayDTO> addvertismentDisplayDTOS = new ArrayList<>();
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();
        for (Addvertisment addvertisment : addvertisments) {
        	System.out.println(username);
        	System.out.println(addvertisment.getCompany().getUsername());
            if(addvertisment.getCompany().getUsername().equals(username)) {
                addvertismentDisplayDTOS.add(new AddvertismentDisplayDTO(addvertisment));
            }
        }
        return addvertismentDisplayDTOS;
    }

    public Addvertisment createAddvertisment(AddvertismentDTO addvertismentDTO) {

        Addvertisment addvertisment = newDTOtoReal(addvertismentDTO);
        Addvertisment real = addvertismentRepository.save(addvertisment);
        for(ImageDTO i: addvertismentDTO.getImages()){
            Image image = this.createImage(i);
            image.setAddvertisment(real);
            imageRepository.save(image);
        }
        for(ReservedDateDTO r: addvertismentDTO.getArrayEvents()){
            ReservedDate reservedDate = this.createReservedDate(r);
            reservedDate.setAddvertisment(real);
            reservedDateRepository.save(reservedDate);
        }


        return addvertisment;

    }

    public Addvertisment newDTOtoReal(AddvertismentDTO dto){
        Addvertisment real = new Addvertisment();
        real.setCdw(dto.isCdw());
        real.setChild_seats(dto.getChild_seats());
        real.setLocation(dto.getLocation());
        real.setMileage(dto.getMileage());
        real.setMileage_limit(dto.getMileage_limit());
        real.setDaily_price(dto.getDaily_price());
        real.setCompany(companyRepository.findByUsername(dto.getOwner()));
        real.setBrand(brandRepository.findById(dto.getBrand_id()).orElse(null));
        real.setFuel_type(fuelTypeRepository.findById(dto.getFuel_type_id()).orElse(null));
        real.setTransmission_type(transmissionTypeRepository.findById(dto.getTransmission_type_id()).orElse(null));
        real.setVehicle_class(vehicleClassRepository.findById(dto.getVehicle_class_id()).orElse(null));
        real.setVehicle_model(vehicleModelRepository.findById(dto.getVehicle_model_id()).orElse(null));
        real.setPricelist(dto.getPricelist());

        return real;
    }

    public Image createImage(ImageDTO i){
        Image image = new Image();
        image.setUrl(i.getUrl());

        return image;
    }
    public ReservedDate createReservedDate(ReservedDateDTO r){
        ReservedDate reservedDate = new ReservedDate();
        reservedDate.setOneDate(r.getOneDate());

        return reservedDate;
    }

        public float updateMileage(float kilometresCrossed, Long id_add){

            Addvertisment addvertisment = addvertismentRepository.getOne(id_add);

            float newMileage = addvertisment.getMileage() + kilometresCrossed;
            addvertisment.setMileage(newMileage);
            addvertismentRepository.save(addvertisment);

            float crossedOverKilometres = checkMileageLimit(kilometresCrossed, addvertisment);

            if(crossedOverKilometres != 0){
                return crossedOverKilometres * addvertisment.getPricelist().getOverlimitPrice();
            }else{
                return 0;
            }
        }

    public float changeUpdatedMileage(float kilometresCrossed, Long id_add, float old_kilometres){

        Addvertisment addvertisment = addvertismentRepository.getOne(id_add);

        float newMileage = addvertisment.getMileage() - old_kilometres + kilometresCrossed;
        addvertisment.setMileage(newMileage);
        addvertismentRepository.save(addvertisment);

        float crossedOverKilometres = checkMileageLimit(kilometresCrossed, addvertisment);

        if(crossedOverKilometres != 0){
            return crossedOverKilometres * addvertisment.getPricelist().getOverlimitPrice();
        }else{
            return 0;
        }
    }

    public float checkMileageLimit(float kilometresCrossed, Addvertisment addvertisment){
        float crossedOverKilometres = 0;
        if(kilometresCrossed > addvertisment.getMileage_limit() && addvertisment.getMileage_limit() != 0){
            crossedOverKilometres = kilometresCrossed - addvertisment.getMileage_limit();
        }

        return crossedOverKilometres;
    }

    public List<AddvertismentDTO> getByQuery(SearchQueryDTO searchQueryDTO) {

        SearchQueryDTO sDTO = checkIfEmpty(searchQueryDTO);

        int minPrice = parseMinPrice(searchQueryDTO);
        int maxPrice = parseMaxPrice(searchQueryDTO);
        int minMileage = parseMinMileage(searchQueryDTO);
        int maxMileage = parseMaxMileage(searchQueryDTO);


        List<Addvertisment> searches = addvertismentRepository.getByQuery(sDTO.getSelectBrand(), sDTO.getSelectModel(), sDTO.getSelectClass(), sDTO.getSelectTransmission(), sDTO.getSelectGas(), sDTO.getSelectLocation(), sDTO.getSelectChildSeats(), minPrice, maxPrice, minMileage, maxMileage);

        List<Addvertisment> dateSearches = searchDates(searches, searchQueryDTO);

        List<AddvertismentDTO> searchDTOS = new ArrayList<>();
        for(Addvertisment search: dateSearches) {
            AddvertismentDTO searchDTO = new AddvertismentDTO(search);
            searchDTOS.add(searchDTO);
        }
        return searchDTOS;
    }

    SearchQueryDTO checkIfEmpty(SearchQueryDTO searchQueryDTO){
        if(searchQueryDTO.getSelectBrand().isEmpty()){
            searchQueryDTO.getSelectBrand().add("emptyBrand");
        }
        if(searchQueryDTO.getSelectModel().isEmpty()){
            searchQueryDTO.getSelectModel().add("emptyModel");
        }
        if(searchQueryDTO.getSelectClass().isEmpty()){
            searchQueryDTO.getSelectClass().add("emptyClass");
        }
        if(searchQueryDTO.getSelectTransmission().isEmpty()){
            searchQueryDTO.getSelectTransmission().add("emptyTransmission");
        }
        if(searchQueryDTO.getSelectGas().isEmpty()){
            searchQueryDTO.getSelectGas().add("emptyGas");
        }
        if(searchQueryDTO.getSelectLocation().isEmpty()){
            searchQueryDTO.getSelectLocation().add("emptyLocation");
        }
        if(searchQueryDTO.getSelectChildSeats().isEmpty()){
            searchQueryDTO.getSelectChildSeats().add(100);
        }

        return searchQueryDTO;
    }

    int parseMinPrice(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMinPrice() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMinPrice());
        }else{
            return 0;
        }

    }

    int parseMaxPrice(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMaxPrice() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMaxPrice());
        }else{
            return 0;
        }
    }

    int parseMinMileage(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMinMileage() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMinMileage());
        }else{
            return 0;
        }
    }

    int parseMaxMileage(SearchQueryDTO searchQueryDTO){

        if(searchQueryDTO.getSelectMaxMileage() != null){
            return Integer.parseInt(searchQueryDTO.getSelectMaxMileage());
        }else{
            return 0;
        }
    }

    List<Addvertisment> searchDates(List<Addvertisment> searches, SearchQueryDTO searchQueryDTO){

        List<Addvertisment> searchList = new ArrayList<>();

        for(Addvertisment search : searches){
            List<ReservedDate> reservedDatesList = reservedDateRepository.getAllByAddvertismentId(search.getId());

            boolean flag = false;
            for(ReservedDate reservedDate: reservedDatesList){
                for(String date: searchQueryDTO.getDates()){
                    if(reservedDate.getOneDate().equals(date)){
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                searchList.add(search);
            }
        }

        return searchList;
    }

    public Addvertisment save(AddvertismentDTO addDTO) {
        Addvertisment search = newDTOtoReal(addDTO);
        addvertismentRepository.save(search);

        for(ImageDTO i: addDTO.getImages()){
            Image image = this.createImage(i);
            image.setAddvertisment(search);
            imageRepository.save(image);
        }

        for(ReservedDateDTO r: addDTO.getArrayEvents()){
            ReservedDate reservedDate = this.createReservedDate(r);
            reservedDate.setAddvertisment(search);
            reservedDateRepository.save(reservedDate);
        }


        return search;
    }

    
    public void deleteAddvertisment(Long id) throws ValidationException {
        Optional<Addvertisment> add = addvertismentRepository.findById(id);
        if (!add.isPresent()){
            throw new ValidationException("Add with that id doesn't exist!");
        }
/*
        try {
            BrandDTO dto = new BrandDTO(id, "delete");
            dto.setOperation(OperationEnum.DELETE);
            this.brandProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }*/
        for (ReservedDate date : add.get().getReservedDates()) {
			reservedDateRepository.delete(date);
		}

        for (Image image : add.get().getImages()) {
			imageRepository.delete(image);
		}

        for (Grade grade : add.get().getGrades()) {
			gradeRepository.delete(grade);
		}

        for (Comment comment : add.get().getComments()) {
			commentRepository.delete(comment);
		}

        addvertismentRepository.delete(add.get());

    }

}
