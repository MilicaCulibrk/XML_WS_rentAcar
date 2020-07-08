package addvertisment.mq.producer;

import addvertisment.dto.FuelTypeDTO;
import addvertisment.dto.VehicleClassDTO;
import addvertisment.mq.configuration.RabbitMQConfigurationClass;
import addvertisment.mq.configuration.RabbitMQConfigurationFuelType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class FuelTypeProducer {

    private final RabbitTemplate rabbitTemplate;

    public FuelTypeProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(FuelTypeDTO message) {

        rabbitTemplate.convertAndSend(RabbitMQConfigurationFuelType.FUEL_TYPE_EXCHANGE_NAME, RabbitMQConfigurationFuelType.FUEL_TYPE_ROUTING_KEY, message);
        System.out.println("-----------Fuel type sent to search-----------------");
    }
}
