package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.model.FuelTypes;
import searchService.repository.BrandsRepository;
import searchService.repository.FuelTypesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuelTypesService {

    @Autowired
    private FuelTypesRepository fuelTypesRepository;

    public List<String> getFuelTypeNames() {
        List<String> fuelTypeNames = new ArrayList<>();
        List<FuelTypes> fuelTypes = fuelTypesRepository.findAll();
        for (FuelTypes fuelType : fuelTypes) {
            fuelTypeNames.add(fuelType.getFuel_type_name());
        }
        return fuelTypeNames;
    }
}
