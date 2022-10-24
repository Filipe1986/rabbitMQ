package com.filipe.rabbitmq.message;

import com.filipe.domain.constants.Constants;
import com.filipe.domain.event.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {


	private static final Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

	@RabbitListener(queues = Constants.RabbitMqQueue.Queues.TOPIC_QUEUE)
	public void topicQueue(SimpleMessage message) {
		message.setQueue(Constants.RabbitMqQueue.Queues.TOPIC_QUEUE);
		if(!message.getTopic().equals("topic")){
			throw new IllegalArgumentException();
		}
		logger.info(message.toString());

	}

}