package addvertisment.service;

import addvertisment.dto.FuelTypeDTO;
import addvertisment.dto.VehicleClassDTO;
import addvertisment.model.FuelType;
import addvertisment.model.VehicleClass;
import addvertisment.repository.VehicleClassRepository;
import addvertisment.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleClassService {

    @Autowired
    private VehicleClassRepository vehicleClassRepository;

    public List<VehicleClassDTO> getAllClasses() {
        List<VehicleClassDTO> classDTOlist = new ArrayList<>();
        List<VehicleClass> vehicleClasses = vehicleClassRepository.findAll();
        for (VehicleClass vehicleClass : vehicleClasses) {
            classDTOlist.add(new VehicleClassDTO(vehicleClass));
        }
        return classDTOlist;
    }

    public void createVehicleClass(VehicleClassDTO vehicleClassDTO) throws ValidationException {

        //ako vec postoji klasa sa istim imenomd
        List<VehicleClass> vehicleClassList = vehicleClassRepository.findAll();
        for(VehicleClass vehicleClass: vehicleClassList){
            if(vehicleClass.getVehicle_class_name().equals(vehicleClassDTO.getVehicle_class_name())){
                throw new ValidationException("Class with this name already exists!");
            }
        }

        VehicleClass vehicleClass = newDTOtoReal(vehicleClassDTO);

        vehicleClassRepository.save(vehicleClass);
    }

    public VehicleClass newDTOtoReal(VehicleClassDTO dto){
        VehicleClass real = new VehicleClass();
        real.setVehicle_class_name(dto.getVehicle_class_name());
        return real;
    }

}
