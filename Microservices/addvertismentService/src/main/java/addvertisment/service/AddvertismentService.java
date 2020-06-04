package addvertisment.service;

import addvertisment.dto.*;
import addvertisment.model.*;
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



    public List<AddvertismentDTO> getAllAddvertisments() {
        List<AddvertismentDTO> addvertismentsDTOlist = new ArrayList<>();
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();
        for (Addvertisment addvertisment : addvertisments) {
            addvertismentsDTOlist.add(new AddvertismentDTO(addvertisment));
        }
        return addvertismentsDTOlist;
    }

    public Addvertisment createAddvertisment(AddvertismentDTO addvertismentDTO) {

        Addvertisment addvertisment = newDTOtoReal(addvertismentDTO);
        addvertismentRepository.save(addvertisment);

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
