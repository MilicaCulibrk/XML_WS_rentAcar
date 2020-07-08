package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.BrandsDTO;
import searchService.dto.ImagesDTO;
import searchService.dto.ReservedDatesDTO;
import searchService.model.Brands;
import searchService.model.Images;
import searchService.model.ReservedDates;
import searchService.model.Search;
import searchService.mq.dto.AddDTO;
import searchService.repository.BrandsRepository;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public List<String> getBrandNames() {
        List<String> brandNames = new ArrayList<>();
        List<Brands> brands = brandsRepository.findAll();
        for (Brands  brand : brands) {
            brandNames.add(brand.getBrands_name());
        }
        return brandNames;
    }

    public Brands save(BrandsDTO brandsDTO) {

        Brands brands = newDTOtoReal(brandsDTO);
        brandsRepository.save(brands);

        return brands;
    }

    public void update(BrandsDTO brandsDTO) {

        Brands brand = brandsRepository.getOne(brandsDTO.getId());
        existingDTOtoReal(brand, brandsDTO);

        brandsRepository.save(brand);
    }

    public void delete(BrandsDTO brandsDTO){
        System.out.println(brandsDTO.getId());

        List<Brands> brands = brandsRepository.findAll();

        for(Brands br: brands){
            if(br.getId().equals(brandsDTO.getId())){
                Brands brand = br;
                brandsRepository.delete(brand);
            }
        }

    }

    public Brands newDTOtoReal(BrandsDTO dto){
        Brands real = new Brands();
        real.setId(dto.getId());
        real.setBrands_name(dto.getBrand_name());
        return real;
    }

    public void existingDTOtoReal(Brands real, BrandsDTO dto){
        real.setBrands_name(dto.getBrand_name());
        return;
    }

}
