package com.filipe.rabbitmq.constants;

/**
 * 
 * @author Filipe Gonçalves
 *
 * Class to keep Constants
 */
public class Constants {



	private Constants() {}

	public static class RoutingKey {
		private RoutingKey() {}

		public static final String FOO_BAR_FIZZ = "foo.bar.fizz";

	}
	
	public static class Url {
		private Url() {}
		
		public static final String SEARCH_PATH = "/search";

	}
	
	public static class Exchange {
		private Exchange() {}
		public static final String TOPIC_TEXT = "topic-text";
		public static final String TOPIC_JSON = "topic-json";
	}

	public static class RabbitMqQueue{
		private RabbitMqQueue() {}
		public static final String QUEUE_NAME = "queue1";
		public static final String SECOND_QUEUE = "secondQueue";

		public static class Topics{
			private Topics() {}
			public static final String TOPIC_TEXT = "topic-text";
			public static final String TOPIC_JSON = "topic-json";
			public static final String MY_EXCHANGE = "myExchange";
		}
	}
	
}