package addvertisment.mq.producer;

import addvertisment.mq.dto.AddDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import addvertisment.mq.configuration.RabbitMQConfiguration;

@Component
public class AddvertismentProducer {

    private final RabbitTemplate rabbitTemplate;

    public AddvertismentProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(AddDTO message) {

        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME, RabbitMQConfiguration.ROUTING_KEY, message);

    }
}
