package com.filipe.rabbitmq.message;

import com.filipe.domain.constants.Constants;
import com.filipe.domain.constants.Constants.RabbitMqQueue;
import com.filipe.domain.event.SimpleMessage;
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
public class Receiver {

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(RabbitMqQueue.Exchange.TOPIC_EXCHANGE);
	}

	@Bean
	Queue queue() {
		return new Queue(RabbitMqQueue.Queues.TOPIC_QUEUE_0, true);
	}



	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(RabbitMqQueue.RoutingKey.ROUTING_KEY_1);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(RabbitMqQueue.Queues.TOPIC_QUEUE_0);
		container.setMessageListener(listenerAdapter);
		
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	public void receiveMessage(SimpleMessage message) {
		message.setQueue(Constants.RabbitMqQueue.Queues.TOPIC_QUEUE_0);
		System.out.println("Received <" + message + ">");
	}

}