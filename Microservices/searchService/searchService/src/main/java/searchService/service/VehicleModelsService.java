package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.model.VehicleClasses;
import searchService.model.VehicleModels;
import searchService.repository.BrandsRepository;
import searchService.repository.VehicleModelsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleModelsService {

    @Autowired
    private VehicleModelsRepository vehicleModelsRepository;

    public List<String> getVehicleModelNames() {
        List<String> vehicleModelNames = new ArrayList<>();
        List<VehicleModels> vehicleModels = vehicleModelsRepository.findAll();
        for (VehicleModels vehicleModel : vehicleModels) {
            vehicleModelNames.add(vehicleModel.getVehicle_model_name());
        }
        return vehicleModelNames;
    }
}


