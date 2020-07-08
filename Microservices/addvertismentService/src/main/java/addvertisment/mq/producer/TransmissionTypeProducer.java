package addvertisment.mq.producer;

import addvertisment.dto.TransmissionTypeDTO;
import addvertisment.dto.VehicleModelDTO;
import addvertisment.mq.configuration.RabbitMQConfigurationModel;
import addvertisment.mq.configuration.RabbitMQConfigurationTransmissionType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class TransmissionTypeProducer {

    private final RabbitTemplate rabbitTemplate;

    public TransmissionTypeProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(TransmissionTypeDTO message) {

        rabbitTemplate.convertAndSend(RabbitMQConfigurationTransmissionType.TRANSMISSION_TYPE_EXCHANGE_NAME, RabbitMQConfigurationTransmissionType.TRANSMISSION_TYPE_ROUTING_KEY, message);
        System.out.println("-----------Transmission type sent to search-----------------");
    }
}
