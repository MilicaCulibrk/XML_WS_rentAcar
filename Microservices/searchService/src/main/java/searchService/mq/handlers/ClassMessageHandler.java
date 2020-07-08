package searchService.mq.handlers;

import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.dto.VehicleClassesDTO;
import searchService.service.BrandsService;
import searchService.service.VehicleClassesService;
import searchService.service.VehicleModelsService;

@Component
public class ClassMessageHandler {

    private final VehicleClassesService vehicleClassesService;

    public ClassMessageHandler(VehicleClassesService vehicleClassesService) {
        this.vehicleClassesService = vehicleClassesService;
    }

    public void createEntity(VehicleClassesDTO message) {

        this.vehicleClassesService.save(message);
        System.out.println("-------------------- Created class in search ----------------------.");

    }

    public void updateEntity(VehicleClassesDTO message) {

        this.vehicleClassesService.update(message);
        System.out.println("-------------------- Updated class in search ----------------------.");

    }

    public void deleteEntity(VehicleClassesDTO message) {

        this.vehicleClassesService.delete(message);
        System.out.println("-------------------- Deleted class in search ----------------------.");

    }

}
