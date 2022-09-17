package com.filipe.rabbitmq.message;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println(new String(message.getBody()));
	}

	@RabbitListener(queues = "topicQueue2")
	public void listen(Message message) {
		System.out.println(" topicQueue2"  + new String(message.getBody()));
	}
}