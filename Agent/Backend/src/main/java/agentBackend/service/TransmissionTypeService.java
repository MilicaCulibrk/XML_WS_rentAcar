package agentBackend.service;

import agentBackend.dto.TransmissionTypeDTO;
import agentBackend.model.TransmissionType;
import agentBackend.repository.TransmissionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransmissionTypeService {

    @Autowired
    private TransmissionTypeRepository transmissionTypeRepository;

    public List<TransmissionTypeDTO> getAllTransmissionTypes() {
        List<TransmissionTypeDTO> transmissionsDTOlist = new ArrayList<>();
        List<TransmissionType> transmissionTypes = transmissionTypeRepository.findAll();
        for (TransmissionType transmissionType : transmissionTypes) {
            transmissionsDTOlist.add(new TransmissionTypeDTO(transmissionType));
        }
        return transmissionsDTOlist;
    }
}
