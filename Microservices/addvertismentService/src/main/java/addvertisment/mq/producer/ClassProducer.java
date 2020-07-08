package addvertisment.mq.producer;

import addvertisment.dto.VehicleClassDTO;
import addvertisment.dto.VehicleModelDTO;
import addvertisment.mq.configuration.RabbitMQConfigurationClass;
import addvertisment.mq.configuration.RabbitMQConfigurationModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClassProducer {


    private final RabbitTemplate rabbitTemplate;

    public ClassProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(VehicleClassDTO message) {

        rabbitTemplate.convertAndSend(RabbitMQConfigurationClass.CLASS_EXCHANGE_NAME, RabbitMQConfigurationClass.CLASS_ROUTING_KEY, message);
        System.out.println("-----------Class sent to search-----------------");
    }
}
