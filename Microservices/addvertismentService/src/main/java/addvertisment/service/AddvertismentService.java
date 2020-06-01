package addvertisment.service;

import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.FuelTypeDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.FuelType;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddvertismentService {

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    public List<AddvertismentDTO> getAllAddvertisments() {
        List<AddvertismentDTO> addvertismentsDTOlist = new ArrayList<>();
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();
        for (Addvertisment addvertisment : addvertisments) {
            addvertismentsDTOlist.add(new AddvertismentDTO(addvertisment));
        }
        return addvertismentsDTOlist;
    }
}
