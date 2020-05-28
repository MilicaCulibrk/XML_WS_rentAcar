package addvertisment.service;

import addvertisment.dto.FuelTypeDTO;
import addvertisment.model.FuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import addvertisment.repository.FuelTypeRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    public List<FuelTypeDTO> getAll() {
        List<FuelTypeDTO> fuelTypesDTO = new ArrayList<>();
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();
        for (FuelType fuelType : fuelTypes) {
            fuelTypesDTO.add(new FuelTypeDTO(fuelType));
        }
        return fuelTypesDTO;
    }

    public void createFuelType(FuelTypeDTO fuelTypeDTO){
        
        FuelType fuelType = DTOtoReal(fuelTypeDTO);

        fuelTypeRepository.save(fuelType);
    }

    public FuelType DTOtoReal(FuelTypeDTO dto){
        FuelType real = new FuelType();
        real.setFuel_type_name(dto.getFuel_type_name());
        return real;
    }

}
