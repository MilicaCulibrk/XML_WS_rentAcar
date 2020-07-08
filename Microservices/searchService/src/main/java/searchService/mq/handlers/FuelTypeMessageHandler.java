package searchService.mq.handlers;

import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.dto.FuelTypesDTO;
import searchService.service.BrandsService;
import searchService.service.FuelTypesService;

@Component
public class FuelTypeMessageHandler {

    private final FuelTypesService fuelTypesService;

    public FuelTypeMessageHandler(FuelTypesService fuelTypesService) {
        this.fuelTypesService = fuelTypesService;
    }

    public void createEntity(FuelTypesDTO message) {

        this.fuelTypesService.save(message);
        System.out.println("-------------------- Created fuel type in search ----------------------.");

    }

    public void updateEntity(FuelTypesDTO message) {

        this.fuelTypesService.update(message);
        System.out.println("-------------------- Updated fuel type in search ----------------------.");

    }

    public void deleteEntity(FuelTypesDTO message) {

        this.fuelTypesService.delete(message);
        System.out.println("-------------------- Deleted fuel type in search ----------------------.");

    }
}
