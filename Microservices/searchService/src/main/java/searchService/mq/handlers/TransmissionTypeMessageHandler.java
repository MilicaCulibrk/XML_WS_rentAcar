package searchService.mq.handlers;

import org.springframework.stereotype.Component;
import searchService.dto.TransmissionTypesDTO;
import searchService.dto.VehicleModelsDTO;
import searchService.service.TransmissionTypesService;
import searchService.service.VehicleModelsService;

@Component
public class TransmissionTypeMessageHandler {

    private final TransmissionTypesService transmissionTypesService;

    public TransmissionTypeMessageHandler(TransmissionTypesService transmissionTypesService) {
        this.transmissionTypesService = transmissionTypesService;
    }

    public void createEntity(TransmissionTypesDTO message) {

        this.transmissionTypesService.save(message);
        System.out.println("-------------------- Created transmission type in search ----------------------.");

    }

    public void updateEntity(TransmissionTypesDTO message) {

        this.transmissionTypesService.update(message);
        System.out.println("-------------------- Updated transmission type in search ----------------------.");

    }

    public void deleteEntity(TransmissionTypesDTO message) {

        this.transmissionTypesService.delete(message);
        System.out.println("-------------------- Deleted transmission type in search ----------------------.");

    }
}
