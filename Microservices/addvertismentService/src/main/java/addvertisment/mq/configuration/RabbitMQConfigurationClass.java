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
public class RabbitMQConfigurationClass {


    public static final String CLASS_EXCHANGE_NAME = "class_search";
    public static final String CLASS_ROUTING_KEY = "class_key";
    public static final String CLASS_QUEUE_NAME = "class";

    @Bean
    public Queue class_queue() {
        return new Queue(CLASS_QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange classtipsExchange() {
        return new TopicExchange(CLASS_EXCHANGE_NAME);
    }

    @Bean
    public Binding classqueueToExchangeBinding() {
        return BindingBuilder.bind(class_queue()).to(classtipsExchange()).with(CLASS_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter classmessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate classrabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(classmessageConverter());
        return rabbitTemplate;
    }
}
