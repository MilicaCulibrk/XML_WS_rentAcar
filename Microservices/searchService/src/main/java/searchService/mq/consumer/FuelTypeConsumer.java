package searchService.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import searchService.dto.FuelTypesDTO;
import searchService.dto.VehicleClassesDTO;
import searchService.mq.configuration.RabbitMQConfigurationClass;
import searchService.mq.configuration.RabbitMQConfigurationFuelType;
import searchService.mq.enums.OperationEnum;
import searchService.mq.handlers.ClassMessageHandler;
import searchService.mq.handlers.FuelTypeMessageHandler;

@Component
public class FuelTypeConsumer {

    private final FuelTypeMessageHandler fuelTypeMessageHandler;

    public FuelTypeConsumer(FuelTypeMessageHandler fuelTypeMessageHandler) {
        this.fuelTypeMessageHandler = fuelTypeMessageHandler;
    }

    @RabbitListener(queues = RabbitMQConfigurationFuelType.FUEL_TYPE_QUEUE_NAME)
    public void brandListen(FuelTypesDTO message) {

        if(message.getOperation() == OperationEnum.CREATE) {
            this.fuelTypeMessageHandler.createEntity(message);
        }

        if(message.getOperation() == OperationEnum.UPDATE) {
            this.fuelTypeMessageHandler.updateEntity(message);
        }

        if(message.getOperation() == OperationEnum.DELETE) {
            this.fuelTypeMessageHandler.deleteEntity(message);
        }

    }

}
