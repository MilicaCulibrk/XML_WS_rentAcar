package searchService.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.dto.VehicleModelsDTO;
import searchService.mq.configuration.RabbitMQConfigurationBrand;
import searchService.mq.configuration.RabbitMQConfigurationModel;
import searchService.mq.enums.OperationEnum;
import searchService.mq.handlers.BrandMessageHandler;
import searchService.mq.handlers.ModelMessageHandler;

@Component
public class ModelConsumer {

    private final ModelMessageHandler modelMessageHandler;

    public ModelConsumer(ModelMessageHandler modelMessageHandler) {
        this.modelMessageHandler = modelMessageHandler;
    }

    @RabbitListener(queues = RabbitMQConfigurationModel.MODEL_QUEUE_NAME)
    public void brandListen(VehicleModelsDTO message) {

        if(message.getOperation() == OperationEnum.CREATE) {
            this.modelMessageHandler.createEntity(message);
        }

        if(message.getOperation() == OperationEnum.UPDATE) {
            this.modelMessageHandler.updateEntity(message);
        }

        if(message.getOperation() == OperationEnum.DELETE) {
            this.modelMessageHandler.deleteEntity(message);
        }

    }
}
