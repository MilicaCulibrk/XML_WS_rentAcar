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
public class RabbitMQConfigurationFuelType {


    public static final String FUEL_TYPE_EXCHANGE_NAME = "fuel_type_search";
    public static final String FUEL_TYPE_ROUTING_KEY = "fuel_type_key";
    public static final String FUEL_TYPE_QUEUE_NAME = "fuel_type";

    @Bean
    public Queue fuel_type_queue() {
        return new Queue(FUEL_TYPE_QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange fueltypetipsExchange() {
        return new TopicExchange(FUEL_TYPE_EXCHANGE_NAME);
    }

    @Bean
    public Binding fueltypequeueToExchangeBinding() {
        return BindingBuilder.bind(fuel_type_queue()).to(fueltypetipsExchange()).with(FUEL_TYPE_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter fueltypemessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate fueltyperabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(fueltypemessageConverter());
        return rabbitTemplate;
    }

}
