package searchService.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import searchService.mq.configuration.RabbitMQConfiguration;
import searchService.mq.dto.AddDTO;
import searchService.mq.enums.OperationEnum;
import searchService.mq.handlers.AddvertismentMessageHandler;

@Component
public class AddvertismentConsumer {

    private final AddvertismentMessageHandler addvertismentMessageHandler;


    public AddvertismentConsumer(AddvertismentMessageHandler adsMessageHandler) {
        this.addvertismentMessageHandler = adsMessageHandler;
    }

    @RabbitListener(queues = RabbitMQConfiguration.ADD_QUEUE_NAME)
    public void addListen(AddDTO message) {

        if(message.getOperation() == OperationEnum.CREATE) {

            this.addvertismentMessageHandler.createEntity(message);

        }

    }
}
