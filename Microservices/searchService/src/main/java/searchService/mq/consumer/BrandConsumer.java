package searchService.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import searchService.dto.BrandsDTO;
import searchService.mq.configuration.RabbitMQConfiguration;
import searchService.mq.configuration.RabbitMQConfigurationBrand;
import searchService.mq.dto.AddDTO;
import searchService.mq.enums.OperationEnum;
import searchService.mq.handlers.AddvertismentMessageHandler;
import searchService.mq.handlers.BrandMessageHandler;

import javax.xml.bind.ValidationException;

@Component
public class BrandConsumer {

    private final BrandMessageHandler brandMessageHandler;

    public BrandConsumer(BrandMessageHandler brandMessageHandler) {
        this.brandMessageHandler = brandMessageHandler;
    }

    @RabbitListener(queues = RabbitMQConfigurationBrand.BRAND_QUEUE_NAME)
    public void brandListen(BrandsDTO message) {

        if(message.getOperation() == OperationEnum.CREATE) {
            this.brandMessageHandler.createEntity(message);
        }

        if(message.getOperation() == OperationEnum.UPDATE) {
            this.brandMessageHandler.updateEntity(message);
        }

        if(message.getOperation() == OperationEnum.DELETE) {
            this.brandMessageHandler.deleteEntity(message);
        }

    }
}
