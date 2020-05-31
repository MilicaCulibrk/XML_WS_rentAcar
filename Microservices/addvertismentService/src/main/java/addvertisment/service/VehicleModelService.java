package addvertisment.service;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.VehicleModelDTO;
import addvertisment.model.Brand;
import addvertisment.model.VehicleModel;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.BrandRepository;
import addvertisment.repository.VehicleModelRepository;
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
