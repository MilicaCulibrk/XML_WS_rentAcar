package addvertisment.service;


import addvertisment.dto.TransmissionTypeDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.FuelType;
import addvertisment.model.TransmissionType;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.TransmissionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransmissionTypeService {

    @Autowired
    private TransmissionTypeRepository transmissionTypeRepository;

    @Autowired
    private AddvertismentRepository addvertismentRepository;

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

    public void updateTransmissionType(TransmissionTypeDTO transmissionTypeDTO) throws ValidationException {

        //ako vec postoji tt sa istim imenom
        List<TransmissionType> transmissionTypeList = transmissionTypeRepository.findAll();
        for(TransmissionType tt: transmissionTypeList){
            if(tt.getTransmission_type_name().equals(transmissionTypeDTO.getTransmission_type_name())){
                throw new ValidationException("Transmission type with this name already exists!");
            }
        }

        TransmissionType transmissionType = transmissionTypeRepository.getOne(transmissionTypeDTO.getId());
        existingDTOtoReal(transmissionType, transmissionTypeDTO);

        transmissionTypeRepository.save(transmissionType);
    }

    public TransmissionType newDTOtoReal(TransmissionTypeDTO dto){
        TransmissionType real = new TransmissionType();
        real.setTransmission_type_name(dto.getTransmission_type_name());
        return real;
    }

    public void deleteTransmissionType(Long id) throws ValidationException {
        Optional<TransmissionType> transmissionType = transmissionTypeRepository.findById(id);
        if (!transmissionType.isPresent()){
            throw new ValidationException("Transmission type with that id doesn't exist!");
        }

        transmissionTypeRepository.delete(transmissionType.get());
    }

    public boolean hasAdds(Long id){
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();

        for(Addvertisment addvertisment: addvertisments){
            if(addvertisment.getFuel_type().getId() == id){
                return true;
            }
        }

        return false;
    }

    public void existingDTOtoReal(TransmissionType real, TransmissionTypeDTO dto){
        real.setTransmission_type_name(dto.getTransmission_type_name());
        return;
    }
}
