package searchService.mq.handlers;

import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.dto.VehicleModelsDTO;
import searchService.service.BrandsService;
import searchService.service.VehicleModelsService;

@Component
public class ModelMessageHandler {

    private final VehicleModelsService vehicleModelsService;

    public ModelMessageHandler(VehicleModelsService vehicleModelsService) {
        this.vehicleModelsService = vehicleModelsService;
    }

    public void createEntity(VehicleModelsDTO message) {

        this.vehicleModelsService.save(message);
        System.out.println("-------------------- Created model in search ----------------------.");

    }

    public void updateEntity(VehicleModelsDTO message) {

        this.vehicleModelsService.update(message);
        System.out.println("-------------------- Updated model in search ----------------------.");

    }

    public void deleteEntity(VehicleModelsDTO message) {

        this.vehicleModelsService.delete(message);
        System.out.println("-------------------- Deleted model in search ----------------------.");

    }
}
