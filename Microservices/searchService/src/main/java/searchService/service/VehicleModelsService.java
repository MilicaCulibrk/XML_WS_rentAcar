package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.BrandsDTO;
import searchService.dto.VehicleModelsDTO;
import searchService.model.Brands;
import searchService.model.VehicleClasses;
import searchService.model.VehicleModels;
import searchService.repository.BrandsRepository;
import searchService.repository.VehicleModelsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleModelsService {

    @Autowired
    private VehicleModelsRepository vehicleModelsRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    public List<String> getVehicleModelNames() {
        List<String> vehicleModelNames = new ArrayList<>();
        List<VehicleModels> vehicleModels = vehicleModelsRepository.findAll();
        for (VehicleModels vehicleModel : vehicleModels) {
            vehicleModelNames.add(vehicleModel.getVehicle_model_name());
        }
        return vehicleModelNames;
    }

    public VehicleModels save(VehicleModelsDTO modelsDTO) {

        VehicleModels models = newDTOtoReal(modelsDTO);
        vehicleModelsRepository.save(models);

        return models;
    }

    public void update(VehicleModelsDTO modelsDTO) {

        VehicleModels model = vehicleModelsRepository.getOne(modelsDTO.getId());
        existingDTOtoReal(model, modelsDTO);

        vehicleModelsRepository.save(model);
    }

    public void delete(VehicleModelsDTO modelsDTO){

        List<VehicleModels> vehicleModels = vehicleModelsRepository.findAll();

        for(VehicleModels m: vehicleModels){
            if(m.getId().equals(modelsDTO.getId())){
                VehicleModels model = m;
                vehicleModelsRepository.delete(model);
            }
        }

    }


    public VehicleModels newDTOtoReal(VehicleModelsDTO dto){
        VehicleModels real = new VehicleModels();
        real.setId(dto.getId());
        real.setVehicle_model_name(dto.getVehicle_model_name());
        real.setBrand(brandsRepository.findById(dto.getBrand_id()).orElse(null));
        return real;
    }

    public void existingDTOtoReal(VehicleModels real, VehicleModelsDTO dto){
        real.setVehicle_model_name(dto.getVehicle_model_name());
        return;
    }
}


