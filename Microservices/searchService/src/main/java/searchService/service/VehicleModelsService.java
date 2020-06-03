package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.repository.BrandsRepository;
import searchService.repository.VehicleModelsRepository;

@Service
public class VehicleModelsService {

    @Autowired
    private VehicleModelsRepository vehicleModelsRepository;
}


