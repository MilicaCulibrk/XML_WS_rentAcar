package addvertisment.service;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.VehicleModelDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Brand;
import addvertisment.model.VehicleModel;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.BrandRepository;
import addvertisment.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void createModel(VehicleModelDTO vehicleModelDTO, Long brandId) throws ValidationException {

        //ako vec postoji model sa istim imenomd
        List<VehicleModel> vehicleModelList = vehicleModelRepository.findAll();
        for(VehicleModel vehicleModel: vehicleModelList){
            //samo ako su im jednaki i brendovi
            if(vehicleModel.getBrand().getId() == brandId){
                if(vehicleModel.getVehicle_model_name().equals(vehicleModelDTO.getVehicle_model_name())){
                    throw new ValidationException("Model with this name already exists!");
                }
            }

        }

        VehicleModel vehicleModel = newDTOtoReal(vehicleModelDTO, brandId);

        vehicleModelRepository.save(vehicleModel);
    }


    public void updateModel(VehicleModelDTO vehicleModelDTO, Long brand_id) throws ValidationException {

        //ako vec postoji model sa istim imenomd
        List<VehicleModel> vehicleModelList = vehicleModelRepository.findAll();
        for(VehicleModel vehicleModel: vehicleModelList){
            //samo ako su im jednaki i brendovi
            if(vehicleModel.getBrand().getId() == brand_id){
                if(vehicleModel.getVehicle_model_name().equals(vehicleModelDTO.getVehicle_model_name())){
                    throw new ValidationException("Model with this name already exists!");
                }
            }

        }

        VehicleModel vehicleModel = vehicleModelRepository.getOne(vehicleModelDTO.getId());
        existingDTOtoReal(vehicleModel, vehicleModelDTO);

        vehicleModelRepository.save(vehicleModel);
    }

    public void deleteModel(Long modelId) throws ValidationException {
        Optional<VehicleModel> vehicleModel = vehicleModelRepository.findById(modelId);
        if (!vehicleModel.isPresent()){
            throw new ValidationException("Model with that id doesn't exist!");
        }

        vehicleModelRepository.delete(vehicleModel.get());
    }

    public VehicleModel newDTOtoReal(VehicleModelDTO dto, Long brand_id){
        VehicleModel real = new VehicleModel();
        real.setVehicle_model_name(dto.getVehicle_model_name());
        Brand brand = brandRepository.getOne(brand_id);
        real.setBrand(brand);
        return real;
    }


    public void existingDTOtoReal(VehicleModel real, VehicleModelDTO dto){
        real.setVehicle_model_name(dto.getVehicle_model_name());
        return;
    }

    public boolean hasAdds(Long model_id){
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();

        for(Addvertisment addvertisment: addvertisments){
            if(addvertisment.getVehicle_model().getId() == model_id){
                return true;
            }
        }

        return false;
    }

}
