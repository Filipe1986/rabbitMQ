package com.filipe.rabbitmq.config;

import com.filipe.domain.constants.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDeadLetterConfig {


    @Bean
    DirectExchange dLTopicExchange() {
        return new DirectExchange("dLTopicExchange");
    }

    @Bean
    Queue dlq() {
        return QueueBuilder.durable("deadLetterQueue").build();
    }

    @Bean
    Binding DLQbinding(Queue dlq, DirectExchange dLTopicExchange) {
        return BindingBuilder.bind(dlq).to(dLTopicExchange).with("routingKeyDeadLetter");
    }

}
