package com.filipe.rabbitmq.message;

import com.filipe.domain.constants.Constants.RabbitMqQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Component
public class Listener {


	@Bean
	Queue queue() {
		return new Queue(RabbitMqQueue.QUEUE_NAME, true);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(RabbitMqQueue.Topics.TOPIC_TEXT);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(RabbitMqQueue.QUEUE_NAME);
		container.setMessageListener(listenerAdapter);
		
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Listener receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}

}