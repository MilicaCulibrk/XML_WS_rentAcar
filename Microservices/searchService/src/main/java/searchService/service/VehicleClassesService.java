package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.BrandsDTO;
import searchService.dto.VehicleClassesDTO;
import searchService.model.Brands;
import searchService.model.VehicleClasses;
import searchService.repository.BrandsRepository;
import searchService.repository.VehicleClassesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleClassesService {

    @Autowired
    private VehicleClassesRepository vehicleClassesRepository;

    public List<String> getVehicleClassesNames() {
        List<String> vehicleClassesNames = new ArrayList<>();
        List<VehicleClasses> vehicleClasses = vehicleClassesRepository.findAll();
        for (VehicleClasses vehicleClass : vehicleClasses) {
            vehicleClassesNames.add(vehicleClass.getVehicle_class_name());
        }
        return vehicleClassesNames;
    }

    public VehicleClasses save(VehicleClassesDTO vehicleClassesDTO) {

        VehicleClasses vehicleClasses = newDTOtoReal(vehicleClassesDTO);
        vehicleClassesRepository.save(vehicleClasses);

        return vehicleClasses;
    }

    public void update(VehicleClassesDTO vehicleClassesDTO) {

        VehicleClasses vehicleClasses = vehicleClassesRepository.getOne(vehicleClassesDTO.getId());
        existingDTOtoReal(vehicleClasses, vehicleClassesDTO);

        vehicleClassesRepository.save(vehicleClasses);
    }

    public void delete(VehicleClassesDTO vehicleClassesDTO){

        List<VehicleClasses> vehicleClasses = vehicleClassesRepository.findAll();

        for(VehicleClasses vc: vehicleClasses){
            if(vc.getId().equals(vehicleClassesDTO.getId())){
                VehicleClasses vehicleClass = vc;
                vehicleClassesRepository.delete(vehicleClass);
            }
        }

    }

    public VehicleClasses newDTOtoReal(VehicleClassesDTO dto){
        VehicleClasses real = new VehicleClasses();
        real.setVehicle_class_name(dto.getVehicle_class_name());
        return real;
    }

    public void existingDTOtoReal(VehicleClasses real, VehicleClassesDTO dto){
        real.setVehicle_class_name(dto.getVehicle_class_name());
        return;
    }
}
