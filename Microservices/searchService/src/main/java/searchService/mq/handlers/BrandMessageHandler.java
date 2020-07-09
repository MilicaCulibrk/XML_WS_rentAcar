package searchService.mq.handlers;

import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.mq.dto.AddDTO;
import searchService.service.BrandsService;
import searchService.service.SearchService;

import javax.xml.bind.ValidationException;

@Component
public class BrandMessageHandler {

    private final BrandsService brandsService;

    public BrandMessageHandler(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    public void createEntity(BrandsDTO message) {

        this.brandsService.save(message);
        System.out.println("-------------------- Created brand in search ----------------------.");

    }

    public void updateEntity(BrandsDTO message) {

        this.brandsService.update(message);
        System.out.println("-------------------- Updated brand in search ----------------------.");

    }

    public void deleteEntity(BrandsDTO message) {

        this.brandsService.delete(message);
        System.out.println("-------------------- Deleted brand in search ----------------------.");

    }

}
