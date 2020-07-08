package addvertisment.service;

import addvertisment.dto.BrandDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Brand;
import addvertisment.model.VehicleModel;
import addvertisment.mq.dto.AddDTO;
import addvertisment.mq.enums.EntityEnum;
import addvertisment.mq.enums.OperationEnum;
import addvertisment.mq.producer.AddvertismentProducer;
import addvertisment.mq.producer.BrandProducer;
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

    private final BrandProducer brandProducer;

    public BrandService(BrandProducer brandProducer) {
        this.brandProducer = brandProducer;
    }

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

        try {
            BrandDTO dto = new BrandDTO(brand);
            dto.setOperation(OperationEnum.CREATE);
            this.brandProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }
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

        try {
            BrandDTO dto = new BrandDTO(brand);
            dto.setOperation(OperationEnum.UPDATE);
            this.brandProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
        }
    }

    public void deleteBrand(Long id) throws ValidationException {
        Optional<Brand> brand = brandRepository.findById(id);
        if (!brand.isPresent()){
            throw new ValidationException("Brand with that id doesn't exist!");
        }

        try {
            BrandDTO dto = new BrandDTO(id, "delete");
            dto.setOperation(OperationEnum.DELETE);
            this.brandProducer.send(dto);
        } catch (Exception e) {
            System.err.println("Did not sync with search service");
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
