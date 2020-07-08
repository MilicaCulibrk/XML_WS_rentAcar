package addvertisment.mq.producer;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.VehicleModelDTO;
import addvertisment.mq.configuration.RabbitMQConfigurationBrand;
import addvertisment.mq.configuration.RabbitMQConfigurationModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ModelProducer {

    private final RabbitTemplate rabbitTemplate;

    public ModelProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(VehicleModelDTO message) {

        rabbitTemplate.convertAndSend(RabbitMQConfigurationModel.MODEL_EXCHANGE_NAME, RabbitMQConfigurationModel.MODEL_ROUTING_KEY, message);
        System.out.println("-----------Model sent to search-----------------");
    }
}
