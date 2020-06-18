package agentBackend.service;

import agentBackend.dto.BrandDTO;
import agentBackend.model.Brand;
import agentBackend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<BrandDTO> getAllBrands() {
        List<BrandDTO> brandsDTOlist = new ArrayList<>();
        List<Brand> brands = brandRepository.findAll();
        for (Brand  brand : brands) {
            brandsDTOlist.add(new BrandDTO(brand));
        }
        return brandsDTOlist;
    }
}
