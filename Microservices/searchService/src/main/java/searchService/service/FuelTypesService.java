package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.BrandsDTO;
import searchService.dto.FuelTypesDTO;
import searchService.model.Brands;
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

    public FuelTypes save(FuelTypesDTO fuelTypesDTO) {

        FuelTypes fuelTypes = newDTOtoReal(fuelTypesDTO);
        fuelTypesRepository.save(fuelTypes);

        return fuelTypes;
    }

    public void update(FuelTypesDTO fuelTypesDTO) {

        FuelTypes fuelTypes = fuelTypesRepository.getOne(fuelTypesDTO.getId());
        existingDTOtoReal(fuelTypes, fuelTypesDTO);

        fuelTypesRepository.save(fuelTypes);
    }

    public void delete(FuelTypesDTO fuelTypesDTO){

        List<FuelTypes> fuelTypes = fuelTypesRepository.findAll();

        for(FuelTypes ft: fuelTypes){
            if(ft.getId().equals(fuelTypesDTO.getId())){
                FuelTypes fuelType = ft;
                fuelTypesRepository.delete(fuelType);
            }
        }

    }

    public FuelTypes newDTOtoReal(FuelTypesDTO dto){
        FuelTypes real = new FuelTypes();
        real.setId(dto.getId());
        real.setFuel_type_name(dto.getFuel_type_name());
        return real;
    }

    public void existingDTOtoReal(FuelTypes real, FuelTypesDTO dto){
        real.setFuel_type_name(dto.getFuel_type_name());
        return;
    }
}
