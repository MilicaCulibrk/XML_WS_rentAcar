package addvertisment.service;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.FuelTypeDTO;
import addvertisment.dto.VehicleClassDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.FuelType;
import addvertisment.model.VehicleClass;
import addvertisment.mq.enums.OperationEnum;
import addvertisment.mq.producer.BrandProducer;
import addvertisment.mq.producer.ClassProducer;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.VehicleClassRepository;
import addvertisment.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleClassService {

    @Autowired
    private VehicleClassRepository vehicleClassRepository;

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    private final ClassProducer classProducer;

    public VehicleClassService(ClassProducer classProducer) {
        this.classProducer = classProducer;
    }

    public List<VehicleClassDTO> getAllClasses() {
        List<VehicleClassDTO> classDTOlist = new ArrayList<>();
        List<VehicleClass> vehicleClasses = vehicleClassRepository.findAll();
        for (VehicleClass vehicleClass : vehicleClasses) {
            classDTOlist.add(new VehicleClassDTO(vehicleClass));
        }
        return classDTOlist;
    }

    public VehicleClass createVehicleClass(VehicleClassDTO vehicleClassDTO) throws ValidationException {

        //ako vec postoji klasa sa istim imenomd
        List<VehicleClass> vehicleClassList = vehicleClassRepository.findAll();
        for(VehicleClass vehicleClass: vehicleClassList){
            if(vehicleClass.getVehicle_class_name().equals(vehicleClassDTO.getVehicle_class_name())){
                throw new ValidationException("Class with this name already exists!");
            }
        }

        VehicleClass vehicleClass = newDTOtoReal(vehicleClassDTO);

        vehicleClassRepository.save(vehicleClass);

        try {
            VehicleClassDTO dto = new VehicleClassDTO(vehicleClass);
            dto.setOperation(OperationEnum.CREATE);
            this.classProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }

        return vehicleClass;
    }

    public void updateVehicleClass(VehicleClassDTO vehicleClassDTO) throws ValidationException {

        //ako vec postoji klasa sa istim imenomd
        List<VehicleClass> classList = vehicleClassRepository.findAll();
        for(VehicleClass vehicleClass: classList){
            if(vehicleClass.getVehicle_class_name().equals(vehicleClassDTO.getVehicle_class_name())){
                throw new ValidationException("Vehicle class with this name already exists!");
            }
        }

        VehicleClass vehicleClass = vehicleClassRepository.getOne(vehicleClassDTO.getId());
        existingDTOtoReal(vehicleClass, vehicleClassDTO);

        vehicleClassRepository.save(vehicleClass);

        try {
            VehicleClassDTO dto = new VehicleClassDTO(vehicleClass);
            dto.setOperation(OperationEnum.UPDATE);
            this.classProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }
    }

    public void deleteVehicleClass(Long id) throws ValidationException {
        Optional<VehicleClass> vehicleClass = vehicleClassRepository.findById(id);
        if (!vehicleClass.isPresent()){
            throw new ValidationException("Vehicle with that id doesn't exist!");
        }

        try {
            VehicleClassDTO dto = new VehicleClassDTO(id, "delete");
            dto.setOperation(OperationEnum.DELETE);
            this.classProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }


        vehicleClassRepository.delete(vehicleClass.get());
    }

    public VehicleClass newDTOtoReal(VehicleClassDTO dto){
        VehicleClass real = new VehicleClass();
        real.setVehicle_class_name(dto.getVehicle_class_name());
        return real;
    }

    public void existingDTOtoReal(VehicleClass real, VehicleClassDTO dto){
        real.setVehicle_class_name(dto.getVehicle_class_name());
        return;
    }

    public boolean hasAdds(Long id){
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();

        for(Addvertisment addvertisment: addvertisments){
            if(addvertisment.getFuel_type().getId() == id){
                return true;
            }
        }

        return false;
    }

}
