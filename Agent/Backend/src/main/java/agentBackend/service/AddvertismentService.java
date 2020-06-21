package agentBackend.service;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.AddvertismentDisplayDTO;
import agentBackend.dto.ImageDTO;
import agentBackend.dto.ReservedDateDTO;
import agentBackend.model.Addvertisment;
import agentBackend.model.Image;
import agentBackend.model.Report;
import agentBackend.model.ReservedDate;
import agentBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
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

    @Autowired
    private CompanyRepository companyRepository;


    public List<AddvertismentDTO> getAllAdds() {
        List<AddvertismentDTO> addsDTOlist = new ArrayList<>();
        List<Addvertisment> adds = addvertismentRepository.findAll();
        for (Addvertisment add : adds) {
            addsDTOlist.add(new AddvertismentDTO(add));
        }
        return addsDTOlist;
    }

    public List<AddvertismentDisplayDTO> getAllUsersAddvertisments(Long id) {
        List<AddvertismentDisplayDTO> addvertismentDisplayDTOS = new ArrayList<>();
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();
        for (Addvertisment addvertisment : addvertisments) {
            if(addvertisment.getCompany().getId().equals(id)) {
                addvertismentDisplayDTOS.add(new AddvertismentDisplayDTO(addvertisment));
            }
        }
        return addvertismentDisplayDTOS;
    }

    public Addvertisment createAddvertisment(AddvertismentDTO addvertismentDTO) {

        Addvertisment addvertisment = newDTOtoReal(addvertismentDTO);
        addvertismentRepository.save(addvertisment);

        return addvertisment;

    }

    public Addvertisment newDTOtoReal(AddvertismentDTO dto){
        System.out.println(dto.getOwner());
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
}
