package agentBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.AddvertismentDisplayDTO;
import agentBackend.dto.ImageDTO;
import agentBackend.dto.ReservedDateDTO;
import agentBackend.model.Addvertisment;
import agentBackend.model.Comment;
import agentBackend.model.Grade;
import agentBackend.model.Image;
import agentBackend.model.ReservedDate;
import agentBackend.repository.AddvertismentRepository;
import agentBackend.repository.BrandRepository;
import agentBackend.repository.CommentRepository;
import agentBackend.repository.CompanyRepository;
import agentBackend.repository.FuelTypeRepository;
import agentBackend.repository.GradeRepository;
import agentBackend.repository.ImageRepository;
import agentBackend.repository.ReservedDateRepository;
import agentBackend.repository.TransmissionTypeRepository;
import agentBackend.repository.VehicleClassRepository;
import agentBackend.repository.VehicleModelRepository;

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
        real.setPriceList(dto.getPricelist());

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

    public void updateMileage(float kilometresCrossed, Long id_add){

        Addvertisment addvertisment = addvertismentRepository.getOne(id_add);

        float newMileage = addvertisment.getMileage() + kilometresCrossed;
        addvertisment.setMileage(newMileage);
        addvertismentRepository.save(addvertisment);
    }

    public void changeUpdatedMileage(float kilometresCrossed, Long id_add, float old_kilometres){

        Addvertisment addvertisment = addvertismentRepository.getOne(id_add);

        float newMileage = addvertisment.getMileage() - old_kilometres + kilometresCrossed;
        addvertisment.setMileage(newMileage);
        addvertismentRepository.save(addvertisment);
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
    public void updateAddvertisment(AddvertismentDTO addvertismentDTO) throws ValidationException {


        Addvertisment addvertisment = addvertismentRepository.getOne(addvertismentDTO.getId());
        existingDTOtoReal(addvertisment, addvertismentDTO);

        try {
            AddvertismentDTO dto = new AddvertismentDTO(addvertisment);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }

        addvertismentRepository.save(addvertisment);
    }
    public void existingDTOtoReal(Addvertisment real, AddvertismentDTO dto){
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
        real.setId(dto.getId());
        return;
    }
    public AddvertismentDTO getOneAddvertisment(Long id) {

        Addvertisment addvertisment = addvertismentRepository.getOne(id);
        AddvertismentDTO addvertismentDTO= new AddvertismentDTO(addvertisment);
        return addvertismentDTO;

    }
}
