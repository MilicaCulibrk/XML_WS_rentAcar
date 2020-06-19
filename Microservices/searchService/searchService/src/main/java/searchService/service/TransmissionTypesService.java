package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
