package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.repository.BrandsRepository;
import searchService.repository.VehicleClassesRepository;

@Service
public class VehicleClassesService {

    @Autowired
    private VehicleClassesRepository vehicleClassesRepository;
}
