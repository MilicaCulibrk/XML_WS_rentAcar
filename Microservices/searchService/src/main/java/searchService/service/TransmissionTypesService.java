package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.FuelTypesDTO;
import searchService.dto.TransmissionTypesDTO;
import searchService.model.FuelTypes;
import searchService.model.TransmissionTypes;
import searchService.repository.BrandsRepository;
import searchService.repository.TransmissionTypesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransmissionTypesService {

    @Autowired
    private TransmissionTypesRepository transmissionTypesRepository;

    public List<String> getTransmissionTypeNames() {
        List<String> transmissionTypeNames = new ArrayList<>();
        List<TransmissionTypes> transmissionTypes = transmissionTypesRepository.findAll();
        for (TransmissionTypes transmissionType : transmissionTypes) {
            transmissionTypeNames.add(transmissionType.getTransmission_type_name());
        }
        return transmissionTypeNames;
    }
   
    public TransmissionTypes save(TransmissionTypesDTO transmissionTypesDTO) {

        TransmissionTypes transmissionTypes = newDTOtoReal(transmissionTypesDTO);
        transmissionTypesRepository.save(transmissionTypes);

        return transmissionTypes;
    }

    public void update(TransmissionTypesDTO transmissionTypesDTO) {

        TransmissionTypes transmissionTypes = transmissionTypesRepository.getOne(transmissionTypesDTO.getId());
        existingDTOtoReal(transmissionTypes, transmissionTypesDTO);

        transmissionTypesRepository.save(transmissionTypes);
    }

    public void delete(TransmissionTypesDTO transmissionTypesDTO){

        List<TransmissionTypes> transmissionTypes = transmissionTypesRepository.findAll();

        for(TransmissionTypes tt: transmissionTypes){
            if(tt.getId().equals(transmissionTypesDTO.getId())){
                TransmissionTypes transmissionType = tt;
                transmissionTypesRepository.delete(transmissionType);
            }
        }

    }

    public TransmissionTypes newDTOtoReal(TransmissionTypesDTO dto){
        TransmissionTypes real = new TransmissionTypes();
        real.setId(dto.getId());
        real.setTransmission_type_name(dto.getTransmission_type_name());
        return real;
    }

    public void existingDTOtoReal(TransmissionTypes real, TransmissionTypesDTO dto){
        real.setTransmission_type_name(dto.getTransmission_type_name());
        return;
    }
}
