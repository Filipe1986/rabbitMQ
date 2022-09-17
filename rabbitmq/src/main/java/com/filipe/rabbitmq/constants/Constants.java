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

	public static class RabbitMqQueue{
		public static final String DIRECT_QUEUE = "directQueue";
		public static final String TOPIC_QUEUE = "topicQueue";

		private RabbitMqQueue() {}
		public static final String QUEUE_NAME = "queue1";
		public static final String EXAMPLE_QUEUE = "exampleQueue";
		public static final String SECOND_QUEUE = "secondQueue";


		public static class Topics{

			public static final String TOPIC = "topic";
			public static final String DIRECT_TOPIC = "directTopic";
			public static final String TOPIC_2 = "topic_2";


			private Topics() {}
			public static final String TOPIC_TEXT = "topic-text";
			public static final String TOPIC_JSON = "topic-json";
			public static final String MY_EXCHANGE = "myExchange";
		}

		public class Exchange {
			Exchange(){}
			public static final String TOPIC_EXCHANGE = "topicExchange";

			public static final String DIRECT_EXCHANGE = "directExchange";
		}

		public class RoutingKey {
			public static final String FOO_BAR_FIZZ = "foo.bar.fizz";

			RoutingKey(){}
		}
	}


}