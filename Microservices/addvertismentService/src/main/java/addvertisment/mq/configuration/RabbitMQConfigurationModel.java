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
public class RabbitMQConfigurationModel {

    public static final String MODEL_EXCHANGE_NAME = "model_search";
    public static final String MODEL_ROUTING_KEY = "model_key";
    public static final String MODEL_QUEUE_NAME = "model";

    @Bean
    public Queue model_queue() {
        return new Queue(MODEL_QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange modeltipsExchange() {
        return new TopicExchange(MODEL_EXCHANGE_NAME);
    }

    @Bean
    public Binding modelqueueToExchangeBinding() {
        return BindingBuilder.bind(model_queue()).to(modeltipsExchange()).with(MODEL_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter modelmessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate modelrabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(modelmessageConverter());
        return rabbitTemplate;
    }
}
