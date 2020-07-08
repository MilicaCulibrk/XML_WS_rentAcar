package searchService.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import searchService.dto.TransmissionTypesDTO;
import searchService.dto.VehicleModelsDTO;
import searchService.mq.configuration.RabbitMQConfigurationModel;
import searchService.mq.configuration.RabbitMQConfigurationTransmissionType;
import searchService.mq.enums.OperationEnum;
import searchService.mq.handlers.ModelMessageHandler;
import searchService.mq.handlers.TransmissionTypeMessageHandler;

@Component
public class TransmissionTypeConsumer {

    private final TransmissionTypeMessageHandler transmissionTypeMessageHandler;

    public TransmissionTypeConsumer(TransmissionTypeMessageHandler transmissionTypeMessageHandler) {
        this.transmissionTypeMessageHandler = transmissionTypeMessageHandler;
    }

    @RabbitListener(queues = RabbitMQConfigurationTransmissionType.TRANSMISSION_TYPE_QUEUE_NAME)
    public void brandListen(TransmissionTypesDTO message) {

        if(message.getOperation() == OperationEnum.CREATE) {
            this.transmissionTypeMessageHandler.createEntity(message);
        }

        if(message.getOperation() == OperationEnum.UPDATE) {
            this.transmissionTypeMessageHandler.updateEntity(message);
        }

        if(message.getOperation() == OperationEnum.DELETE) {
            this.transmissionTypeMessageHandler.deleteEntity(message);
        }

    }
}
