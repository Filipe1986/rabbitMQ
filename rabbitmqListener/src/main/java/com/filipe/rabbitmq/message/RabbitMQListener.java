package com.filipe.rabbitmq.message;

import com.filipe.rabbitmq.constants.Constants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {


	@RabbitListener(queues = Constants.RabbitMqQueue.TOPIC_QUEUE)
	public void topicQueue(Message message) {
		System.out.println("topic:");
		System.out.println(new String(message.getBody()));
		System.out.println("end\n");
	}

	@RabbitListener(queues = Constants.RabbitMqQueue.TOPIC_QUEUE_2)
	public void topicQueue2(Message message) {
		System.out.println("topicQueue2:");
		System.out.println(new String(message.getBody()));
		System.out.println("end\n");
	}

}