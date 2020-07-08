package addvertisment.mq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigurationTransmissionType {

    public static final String TRANSMISSION_TYPE_EXCHANGE_NAME = "transmission_type_search";
    public static final String TRANSMISSION_TYPE_ROUTING_KEY = "transmission_type_key";
    public static final String TRANSMISSION_TYPE_QUEUE_NAME = "transmission_type";

    @Bean
    public Queue transmission_type_queue() {
        return new Queue(TRANSMISSION_TYPE_QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange transmissiontypetipsExchange() {
        return new TopicExchange(TRANSMISSION_TYPE_EXCHANGE_NAME);
    }

    @Bean
    public Binding transmissiontypequeueToExchangeBinding() {
        return BindingBuilder.bind(transmission_type_queue()).to(transmissiontypetipsExchange()).with(TRANSMISSION_TYPE_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter transmissiontypemessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate transmissiontyperabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(transmissiontypemessageConverter());
        return rabbitTemplate;
    }

}
