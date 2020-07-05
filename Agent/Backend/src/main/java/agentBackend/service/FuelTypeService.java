package agentBackend.service;

import agentBackend.dto.FuelTypeDTO;
import agentBackend.model.FuelType;
import agentBackend.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    public List<FuelTypeDTO> getAllFuelTypes() {
        List<FuelTypeDTO> fuelTypesDTOlist = new ArrayList<>();
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();
        for (FuelType fuelType : fuelTypes) {
            fuelTypesDTOlist.add(new FuelTypeDTO(fuelType));
        }
        return fuelTypesDTOlist;
    }
    public FuelType createFuelType(FuelTypeDTO fuelTypeDTO) {

        //ako vec postoji fuel type sa istim imenomd
        List<FuelType> fuelTypeList = fuelTypeRepository.findAll();
      /*  for(FuelType ft: fuelTypeList){
            if(ft.getFuel_type_name().equals(fuelTypeDTO.getFuel_type_name())){
                throw new ValidationException("Fuel type with this name already exists!");
            }
        }
*/
        FuelType fuelType = newDTOtoReal(fuelTypeDTO);

        fuelTypeRepository.save(fuelType);
        return fuelType;
    }
    public FuelType newDTOtoReal(FuelTypeDTO dto){
        FuelType real = new FuelType();
        real.setFuel_type_name(dto.getFuel_type_name());
        return real;
    }
}
