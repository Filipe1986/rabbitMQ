package com.filipe.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

    @Bean
    Exchange exampleExchange(){
        return new TopicExchange("exampleExchange");
    }

    @Bean
    Exchange exchange(){
        return ExchangeBuilder
                .directExchange("exchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange exchange2(){
        return ExchangeBuilder
                .topicExchange("exchange2")
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange("fanoutExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange headersExchange(){
        return ExchangeBuilder
                .headersExchange("headersExchange")
                .ignoreDeclarationExceptions()
                .durable(true)
                .internal()
                .build();
    }


}
