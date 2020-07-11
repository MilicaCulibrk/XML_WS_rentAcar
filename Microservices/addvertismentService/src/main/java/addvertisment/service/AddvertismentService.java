package addvertisment.service;

import addvertisment.dto.*;
import addvertisment.model.*;
import addvertisment.mq.dto.AddDTO;
import addvertisment.mq.enums.EntityEnum;
import addvertisment.mq.enums.OperationEnum;
import addvertisment.mq.producer.AddvertismentProducer;
import addvertisment.mq.producer.FuelTypeProducer;
import addvertisment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;

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
    private CommentRepository commentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private ReservedDateRepository reservedDateRepository;

    private final AddvertismentProducer addvertismentProducer;

    public AddvertismentService(AddvertismentProducer addvertismentProducer) {
        this.addvertismentProducer = addvertismentProducer;
    }

    public List<AddvertismentDTO> getAllAddvertisments() {
        List<AddvertismentDTO> addvertismentsDTOlist = new ArrayList<>();
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();
        for (Addvertisment addvertisment : addvertisments) {
            addvertismentsDTOlist.add(new AddvertismentDTO(addvertisment));
        }
        return addvertismentsDTOlist;
    }
    public List<AddvertismentDisplayDTO> getAllUsersAddvertisments(String username) {
        List<AddvertismentDisplayDTO> addvertismentDisplayDTOS = new ArrayList<>();
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();
        for (Addvertisment addvertisment : addvertisments) {
            if(addvertisment.getAddvertiser_id().equals(username)) {
                addvertismentDisplayDTOS.add(new AddvertismentDisplayDTO(addvertisment));
            }
        }
        return addvertismentDisplayDTOS;
    }

    //poziva se producer poruke za search da bi se ovaj oglas dodao i u tom servisu
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

        try {
            AddDTO dto = new AddDTO(addvertisment);
            dto.setOperation(OperationEnum.CREATE);
            dto.setEntity(EntityEnum.ADD);
            dto.setImages(addvertismentDTO.getImages());
            dto.setDates(addvertismentDTO.getArrayEvents());
            this.addvertismentProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
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
        real.setPrice(dto.getPricelist().getDailyPrice());
        real.setAddvertiser_id(dto.getAddvertiser_id());
        real.setBrand(brandRepository.findById(dto.getBrand_id()).orElse(null));
        real.setFuel_type(fuelTypeRepository.findById(dto.getFuel_type_id()).orElse(null));
        real.setTransmission_type(transmissionTypeRepository.findById(dto.getTransmission_type_id()).orElse(null));
        real.setVehicle_class(vehicleClassRepository.findById(dto.getVehicle_class_id()).orElse(null));
        real.setVehicle_model(vehicleModelRepository.findById(dto.getVehicle_model_id()).orElse(null));
        real.setPricelist(dto.getPricelist());
        return real;
    }

    public AddvertismentRentDTO getAddById(Long id, float kilometresCrossed, float oldKilometres){

        Addvertisment add =  addvertismentRepository.findById(id).orElse(null);

        AddvertismentRentDTO addDTO = new AddvertismentRentDTO();

        addDTO.setMileage_limit(add.getMileage_limit());
        addDTO.setPriceByKm(add.getPricelist().getOverlimitPrice());

        float newMileage = add.getMileage()  - oldKilometres + kilometresCrossed;
        add.setMileage(newMileage);
        addvertismentRepository.save(add);

        System.out.println(add.getMileage());

        try {
            AddDTO dto = new AddDTO(add);
            dto.setOperation(OperationEnum.UPDATE);
            dto.setEntity(EntityEnum.ADD);
            this.addvertismentProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }

        return addDTO;

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
    public void updateAddvertisment(AddvertismentDTO addvertismentDTO) throws ValidationException {


        Addvertisment addvertisment = addvertismentRepository.getOne(addvertismentDTO.getId());
        existingDTOtoReal(addvertisment, addvertismentDTO);

        addvertismentRepository.save(addvertisment);

        try {
            AddDTO dto = new AddDTO(addvertisment);
            dto.setOperation(OperationEnum.UPDATE);
            dto.setEntity(EntityEnum.ADD);
            this.addvertismentProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }
    }
    public void existingDTOtoReal(Addvertisment real, AddvertismentDTO dto){
        real.setCdw(dto.isCdw());
        real.setChild_seats(dto.getChild_seats());
        real.setLocation(dto.getLocation());
        real.setMileage(dto.getMileage());
        real.setMileage_limit(dto.getMileage_limit());
        real.setPricelist(dto.getPricelist());
        real.setPrice(dto.getPricelist().getDailyPrice());
        real.setAddvertiser_id(dto.getAddvertiser_id());
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

    public void deleteAddvertisment(Long id) throws ValidationException {
        Optional<Addvertisment> add = addvertismentRepository.findById(id);
        if (!add.isPresent()){
            throw new ValidationException("Add with that id doesn't exist!");
        }


        try {
            AddDTO dto = new AddDTO(add.get());
            dto.setOperation(OperationEnum.DELETE);
            this.addvertismentProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }


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
            System.out.println("----uso----");
            commentRepository.delete(comment);
        }

        addvertismentRepository.delete(add.get());

    }
}