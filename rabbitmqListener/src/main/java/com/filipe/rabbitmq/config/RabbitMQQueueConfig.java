package com.filipe.rabbitmq.config;

import com.filipe.rabbitmq.constants.Constants;
import com.filipe.rabbitmq.message.Listener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfig {


    @Bean
    Queue exampleQueue(){
        return new Queue(Constants.RabbitMqQueue.EXAMPLE_QUEUE, true);
    }

    @Bean
    Queue Queue2(){
        return QueueBuilder.durable(Constants.RabbitMqQueue.SECOND_QUEUE).autoDelete().exclusive().build();
    }


}
