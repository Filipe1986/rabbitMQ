package com.filipe.rabbitmq.config;

import com.filipe.domain.constants.Constants.RabbitMqQueue;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQListenerConfig {


    @Bean
    Exchange topicExchange(){
        return ExchangeBuilder
                .topicExchange(RabbitMqQueue.Exchange.TOPIC_EXCHANGE)
                .build();
    }

    @Bean
    Queue topicQueue(){

        return QueueBuilder.durable(RabbitMqQueue.Queues.TOPIC_QUEUE)
                .withArgument("x-dead-letter-exchange", RabbitMqQueue.Exchange.DL_TOPIC_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", RabbitMqQueue.RoutingKey.ROUTING_KEY_DEAD_LETTER).build();
    }


    @Bean
    Binding topicBinding() {
        return BindingBuilder
                .bind(topicQueue())
                .to(topicExchange())
                .with(RabbitMqQueue.RoutingKey.ROUTING_KEY_1)
                .noargs();
    }

   @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");

        return cachingConnectionFactory;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueues(topicQueue());
        return container;
    }

}
