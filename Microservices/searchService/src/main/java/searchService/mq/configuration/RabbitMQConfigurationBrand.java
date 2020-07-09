package searchService.mq.configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;
import java.util.List;

@Configuration
public class RabbitMQConfigurationBrand {

    public static final String BRAND_EXCHANGE_NAME = "brand_search";
    public static final String BRAND_ROUTING_KEY = "brand_key";
    public static final String BRAND_QUEUE_NAME = "brand";

    @Bean
    public Queue brand_queue() {
        return new Queue(BRAND_QUEUE_NAME, false);
    }


    @Bean
    public TopicExchange brandtipsExchange() {
        return new TopicExchange(BRAND_EXCHANGE_NAME);
    }


    @Bean
    List<Binding> brandbindings() {
        return Arrays.asList(BindingBuilder.bind(brand_queue()).to(brandtipsExchange()).with(BRAND_ROUTING_KEY));
    }

    @Bean
    public Jackson2JsonMessageConverter brandmessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate brandrabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(brandmessageConverter());
        return rabbitTemplate;
    }
}
