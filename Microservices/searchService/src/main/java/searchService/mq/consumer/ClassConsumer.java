package searchService.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.dto.VehicleClassesDTO;
import searchService.mq.configuration.RabbitMQConfigurationBrand;
import searchService.mq.configuration.RabbitMQConfigurationClass;
import searchService.mq.enums.OperationEnum;
import searchService.mq.handlers.BrandMessageHandler;
import searchService.mq.handlers.ClassMessageHandler;

@Component
public class ClassConsumer {

    private final ClassMessageHandler classMessageHandler;

    public ClassConsumer(ClassMessageHandler classMessageHandler) {
        this.classMessageHandler = classMessageHandler;
    }

    @RabbitListener(queues = RabbitMQConfigurationClass.CLASS_QUEUE_NAME)
    public void brandListen(VehicleClassesDTO message) {

        if(message.getOperation() == OperationEnum.CREATE) {
            this.classMessageHandler.createEntity(message);
        }

        if(message.getOperation() == OperationEnum.UPDATE) {
            this.classMessageHandler.updateEntity(message);
        }

        if(message.getOperation() == OperationEnum.DELETE) {
            this.classMessageHandler.deleteEntity(message);
        }

    }
}
