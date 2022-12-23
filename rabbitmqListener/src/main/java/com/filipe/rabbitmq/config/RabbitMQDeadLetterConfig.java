package com.filipe.rabbitmq.config;

import com.filipe.domain.constants.Constants.RabbitMqQueue;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDeadLetterConfig {


    @Bean
    DirectExchange dLTopicExchange() {
        return new DirectExchange(RabbitMqQueue.Exchange.DL_TOPIC_EXCHANGE);
    }

    @Bean
    Queue dlq() {
        return QueueBuilder.durable(RabbitMqQueue.Queues.DL_QUEUE).build();
    }

    @Bean
    Binding dlQBinding(Queue dlq, DirectExchange dLTopicExchange) {
        return BindingBuilder.bind(dlq).to(dLTopicExchange)
                .with(RabbitMqQueue.RoutingKey.ROUTING_KEY_DEAD_LETTER);
    }

}
