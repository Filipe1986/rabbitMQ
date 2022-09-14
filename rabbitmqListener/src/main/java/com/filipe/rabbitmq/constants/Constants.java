package com.filipe.rabbitmq.constants;

/**
 * 
 * @author Filipe Gonçalves
 *
 * Class to keep Constants
 */
public class Constants {
	
	private Constants() {}
	
	public static class Url {
		private Url() {}
		public static final String SEARCH_PATH = "/search";

	}
	
	public static class Topics{
		private Topics() {}
		public static final String TOPIC_TEXT = "topic-text";
		public static final String TOPIC_JSON = "topic-json";
	}
	
	public static class RabbitMqQueue{
		private RabbitMqQueue() {}
		public static final String QUEUE_NAME = "queue";
	}
	
	
}