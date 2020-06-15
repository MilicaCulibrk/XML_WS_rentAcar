package agentBackend.service;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.model.Addvertisment;
import agentBackend.repository.AddvertismentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddvertismentService {

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    public List<AddvertismentDTO> getAllAdds() {
        List<AddvertismentDTO> addsDTOlist = new ArrayList<>();
        List<Addvertisment> adds = addvertismentRepository.findAll();
        for (Addvertisment add : adds) {
            addsDTOlist.add(new AddvertismentDTO(add));
        }
        return addsDTOlist;
    }
}
