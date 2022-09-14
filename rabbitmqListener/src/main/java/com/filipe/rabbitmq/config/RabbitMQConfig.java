package com.filipe.rabbitmq.config;

import com.filipe.rabbitmq.constants.Constants;
import com.filipe.rabbitmq.message.Listener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue myQueue(){
        return new Queue(Constants.RabbitMqQueue.QUEUE_NAME, true);
    }

    @Bean
    Exchange myTestExchange() {
        return new TopicExchange(Constants.RabbitMqQueue.Topics.TOPIC_TEXT);
    }


    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.topicExchange(Constants.RabbitMqQueue.Topics.MY_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    Binding myBinding() {
/*        return new Binding(Constants.RabbitMqQueue.QUEUE_NAME, Binding.DestinationType.QUEUE
                , Constants.RabbitMqQueue.Topics.MY_EXCHANGE, "topic", null);*/
        return BindingBuilder.bind(myQueue())
                .to(myExchange())
                .with("topic")
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
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueues(myQueue());
        container.setMessageListener(new Listener());

        return container;
    }

}
