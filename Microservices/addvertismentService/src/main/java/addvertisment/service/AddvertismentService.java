package addvertisment.service;

import addvertisment.dto.*;
import addvertisment.model.*;
import addvertisment.mq.dto.AddDTO;
import addvertisment.mq.enums.EntityEnum;
import addvertisment.mq.enums.OperationEnum;
import addvertisment.mq.producer.AddvertismentProducer;
import addvertisment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

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
        addvertismentRepository.save(addvertisment);

        try {
            AddDTO dto = new AddDTO(addvertisment);
            dto.setOperation(OperationEnum.CREATE);
            dto.setEntity(EntityEnum.ADD);
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
        real.setPrice(dto.getPrice());
        real.setAddvertiser_id(dto.getAddvertiser_id());
        real.setBrand(brandRepository.findById(dto.getBrand_id()).orElse(null));
        real.setFuel_type(fuelTypeRepository.findById(dto.getFuel_type_id()).orElse(null));
        real.setTransmission_type(transmissionTypeRepository.findById(dto.getTransmission_type_id()).orElse(null));
        real.setVehicle_class(vehicleClassRepository.findById(dto.getVehicle_class_id()).orElse(null));
        real.setVehicle_model(vehicleModelRepository.findById(dto.getVehicle_model_id()).orElse(null));

        for(ImageDTO i: dto.getImages()){
            Image image = this.createImage(i);
            image.setAddvertisment(real);
            imageRepository.save(image);
        }
        for(ReservedDateDTO r: dto.getArrayEvents()){
            ReservedDate reservedDate = this.createReservedDate(r);
            reservedDate.setAddvertisment(real);
            reservedDateRepository.save(reservedDate);
        }

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


}
