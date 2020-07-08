package addvertisment.mq.producer;

import addvertisment.dto.BrandDTO;
import addvertisment.mq.configuration.RabbitMQConfiguration;
import addvertisment.mq.configuration.RabbitMQConfigurationBrand;
import addvertisment.mq.dto.AddDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class BrandProducer {

    private final RabbitTemplate rabbitTemplate;

    public BrandProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(BrandDTO message) {

        rabbitTemplate.convertAndSend(RabbitMQConfigurationBrand.BRAND_EXCHANGE_NAME, RabbitMQConfigurationBrand.BRAND_ROUTING_KEY, message);
        System.out.println("-----------Brand sent to search-----------------");
    }
}