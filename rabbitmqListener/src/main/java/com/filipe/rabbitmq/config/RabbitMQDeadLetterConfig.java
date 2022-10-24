package com.filipe.rabbitmq.config;

import org.springframework.amqp.core.*;
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
    Binding dlQBinding(Queue dlq, DirectExchange dLTopicExchange) {
        return BindingBuilder.bind(dlq).to(dLTopicExchange).with("routingKeyDeadLetter");
    }

}
