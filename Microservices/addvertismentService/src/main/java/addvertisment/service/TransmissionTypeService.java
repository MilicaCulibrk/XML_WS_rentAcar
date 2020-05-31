package addvertisment.service;

import addvertisment.dto.TransmissionTypeDTO;
import addvertisment.dto.VehicleClassDTO;
import addvertisment.model.TransmissionType;
import addvertisment.model.VehicleClass;
import addvertisment.repository.TransmissionTypeRepository;
import addvertisment.repository.VehicleClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
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

    public void createTransmissionType(TransmissionTypeDTO transmissionTypeDTO) throws ValidationException {

        //ako vec postoji klasa sa istim imenomd
        List<TransmissionType> transmissionTypeList  = transmissionTypeRepository.findAll();
        for(TransmissionType transmissionType: transmissionTypeList){
            if(transmissionType.getTransmission_type_name().equals(transmissionTypeDTO.getTransmission_type_name())){
                throw new ValidationException("Transmission type with this name already exists!");
            }
        }

        TransmissionType transmissionType = newDTOtoReal(transmissionTypeDTO);

        transmissionTypeRepository.save(transmissionType);
    }

    public TransmissionType newDTOtoReal(TransmissionTypeDTO dto){
        TransmissionType real = new TransmissionType();
        real.setTransmission_type_name(dto.getTransmission_type_name());
        return real;
    }
}
