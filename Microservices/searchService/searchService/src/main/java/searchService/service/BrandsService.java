package searchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchService.dto.BrandsDTO;
import searchService.model.Brands;
import searchService.repository.BrandsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public List<String> getBrandNames() {
        List<String> brandNames = new ArrayList<>();
        List<Brands> brands = brandsRepository.findAll();
        for (Brands  brand : brands) {
            brandNames.add(brand.getBrand_name());
        }
        return brandNames;
    }
}
