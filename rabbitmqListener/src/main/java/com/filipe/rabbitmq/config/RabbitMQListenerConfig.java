package com.filipe.rabbitmq.config;

import com.filipe.domain.constants.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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
        return new Queue(Constants.RabbitMqQueue.Queues.TOPIC_QUEUE, true);
    }

/*    @Bean
    Queue topicQueue2(){
        return new Queue(Constants.RabbitMqQueue.TOPIC_QUEUE_2 , true);
    }*/


    @Bean
    Binding topicBinding() {
        return BindingBuilder
                .bind(topicQueue())
                .to(topicExchange())
                .with(Constants.RabbitMqQueue.RoutingKey.ROUTING_KEY_1)
                .noargs();
    }

/*    @Bean
    Binding topicBinding2() {
        return BindingBuilder
                .bind(topicQueue2())
                .to(topicExchange())
                .with(Constants.RabbitMqQueue.Topics.TOPIC_2)
                .noargs();
    }*/


   @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");

        return cachingConnectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueues(topicQueue());
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);

        //container.setQueues(topicQueue(), topicQueue2());

        return container;
    }

}
