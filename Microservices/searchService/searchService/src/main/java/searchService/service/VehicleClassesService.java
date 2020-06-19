package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
