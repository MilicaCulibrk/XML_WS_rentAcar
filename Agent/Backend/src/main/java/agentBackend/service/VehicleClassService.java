package agentBackend.service;

import agentBackend.dto.VehicleClassDTO;
import agentBackend.model.VehicleClass;
import agentBackend.repository.VehicleClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleClassService {

    @Autowired
    private VehicleClassRepository vehicleClassRepository;


    public List<VehicleClassDTO> getAllClasses() {
        List<VehicleClassDTO> classDTOlist = new ArrayList<>();
        List<VehicleClass> vehicleClasses = vehicleClassRepository.findAll();
        for (VehicleClass vehicleClass : vehicleClasses) {
            classDTOlist.add(new VehicleClassDTO(vehicleClass));
        }
        return classDTOlist;
    }
}
