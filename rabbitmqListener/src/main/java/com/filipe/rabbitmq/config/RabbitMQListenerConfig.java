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
public class RabbitMQListenerConfig {


    @Bean
    Exchange topicExchange(){
        return ExchangeBuilder
                .topicExchange(Constants.RabbitMqQueue.Exchange.TOPIC_EXCHANGE)
                .build();
    }

    @Bean
    Queue topicQueue(){

        return QueueBuilder.durable(Constants.RabbitMqQueue.Queues.TOPIC_QUEUE)
                .withArgument("x-dead-letter-exchange", "dLTopicExchange")
                .withArgument("x-dead-letter-routing-key", "routingKeyDeadLetter").build();
    }


    @Bean
    Binding topicBinding() {
        return BindingBuilder
                .bind(topicQueue())
                .to(topicExchange())
                .with(Constants.RabbitMqQueue.RoutingKey.ROUTING_KEY_1)
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
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
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
