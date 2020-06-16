package agentBackend.service;

import agentBackend.dto.FuelTypeDTO;
import agentBackend.model.FuelType;
import agentBackend.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
