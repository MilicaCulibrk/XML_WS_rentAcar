package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.repository.BrandsRepository;
import searchService.repository.FuelTypesRepository;

@Service
public class FuelTypeService {

    @Autowired
    private FuelTypesRepository fuelTypesRepository;
}
