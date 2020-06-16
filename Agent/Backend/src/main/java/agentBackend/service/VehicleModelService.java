package agentBackend.service;

import agentBackend.dto.VehicleModelDTO;
import agentBackend.model.Brand;
import agentBackend.model.VehicleModel;
import agentBackend.repository.AddvertismentRepository;
import agentBackend.repository.BrandRepository;
import agentBackend.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    public List<VehicleModelDTO> getAllModels(Long brandId) {

        Brand brand = brandRepository.getOne(brandId);

        List<VehicleModel> vehicleModels = vehicleModelRepository.findAll();
        List<VehicleModelDTO> modelsDTOlist = new ArrayList<>();

        for(VehicleModel vehicleModel : vehicleModels){
            if(vehicleModel.getBrand().getId() == brandId){
                modelsDTOlist.add(new VehicleModelDTO(vehicleModel));
            }
        }

        System.out.println(modelsDTOlist);
        return modelsDTOlist;
    }
}
