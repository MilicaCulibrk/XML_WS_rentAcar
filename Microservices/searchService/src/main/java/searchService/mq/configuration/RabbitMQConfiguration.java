package searchService.mq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration

public class RabbitMQConfiguration {

    public static final String EXCHANGE_NAME = "add_search";
    public static final String ADD_ROUTING_KEY = "add_key";
    public static final String ADD_QUEUE_NAME = "add";

    @Bean
    public Queue add_queue() {
        return new Queue(ADD_QUEUE_NAME, false);
    }


    @Bean
    public TopicExchange tipsExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }


    @Bean
    List<Binding> bindings() {
        return Arrays.asList(BindingBuilder.bind(add_queue()).to(tipsExchange()).with(ADD_ROUTING_KEY));
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
