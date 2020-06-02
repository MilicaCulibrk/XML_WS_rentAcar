package addvertisment.service;

import addvertisment.dto.BrandDTO;
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
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private AddvertismentRepository addvertismentRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<BrandDTO> getAllBrands() {
        List<BrandDTO> brandsDTOlist = new ArrayList<>();
        List<Brand> brands = brandRepository.findAll();
        for (Brand  brand : brands) {
            brandsDTOlist.add(new BrandDTO(brand));
        }
        return brandsDTOlist;
    }

    public void createBrand(BrandDTO brandDTO) throws ValidationException {

        //ako vec postoji brend sa istim imenomd
        List<Brand> brandList = brandRepository.findAll();
        for(Brand brand: brandList){
            if(brand.getBrand_name().equals(brandDTO.getBrand_name())){
                throw new ValidationException("Brand with this name already exists!");
            }
        }

        Brand brand = newDTOtoReal(brandDTO);

        brandRepository.save(brand);
    }

    public void updateBrand(BrandDTO brandDTO) throws ValidationException {

        //ako vec postoji brend sa istim imenomd
        List<Brand> brandList = brandRepository.findAll();
        for(Brand brand: brandList){
            if(brand.getBrand_name().equals(brandDTO.getBrand_name())){
                throw new ValidationException("Brand with this name already exists!");
            }
        }

        Brand brand = brandRepository.getOne(brandDTO.getId());
        existingDTOtoReal(brand, brandDTO);

        brandRepository.save(brand);
    }

    public void deleteBrand(Long id) throws ValidationException {
        Optional<Brand> brand = brandRepository.findById(id);
        if (!brand.isPresent()){
            throw new ValidationException("Brand with that id doesn't exist!");
        }

        brandRepository.delete(brand.get());
    }

    public Brand newDTOtoReal(BrandDTO dto){
        Brand real = new Brand();
        real.setBrand_name(dto.getBrand_name());
        return real;
    }

    public void existingDTOtoReal(Brand real, BrandDTO dto){
        real.setBrand_name(dto.getBrand_name());
        return;
    }

    public boolean hasAdds(Long id){
        List<Addvertisment> addvertisments = addvertismentRepository.findAll();

        for(Addvertisment addvertisment: addvertisments){
            if(addvertisment.getBrand().getId() == id){
                return true;
            }
        }

        return false;
    }

    public boolean hasModels(Long id){
        List<VehicleModel> vehicleModels = vehicleModelRepository.findAll();

        for(VehicleModel vehicleModel: vehicleModels){
            if(vehicleModel.getBrand().getId() == id){
                return true;
            }
        }

        return false;
    }

}
