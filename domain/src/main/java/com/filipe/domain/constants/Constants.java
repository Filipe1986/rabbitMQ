package com.filipe.domain.constants;

/**
 *
 * @author Filipe Gonçalves
 *
 * Class to keep Constants
 */
public class Constants {

    private Constants() {}

    public static class RabbitMqQueue{
        private RabbitMqQueue() {}

        public static final String DIRECT_QUEUE = "directQueue";
        public static final String TOPIC_QUEUE = "topicQueue";
        public static final String TOPIC_QUEUE_2 = "topicQueue2";
        public static final String QUEUE_NAME = "queue";




        public static class Topics{

            private Topics() {}

            public static final String TOPIC = "topic";
            public static final String DIRECT_TOPIC = "directTopic";
            public static final String TOPIC_2 = "topic_2";


            
            public static final String TOPIC_TEXT = "topic-text";
            public static final String TOPIC_JSON = "topic-json";
            public static final String MY_EXCHANGE = "myExchange";
        }

        public class Exchange {
            Exchange(){}
            public static final String TOPIC_EXCHANGE = "topicExchange";
            public static final String DIRECT_EXCHANGE = "directExchange";
        }

        public class Queues {
            Queues(){}
            public static final String DIRECT_QUEUE = "directQueue";
            public static final String TOPIC_QUEUE_0 = "topic-queue-0";
            public static final String TOPIC_QUEUE_1 = "topic-queue-1";

            public static final String FANOUT_QUEUE_0 = "fanout-queue-0";
            public static final String FANOUT_QUEUE_1 = "fanout-queue-1";

        }

        public class RoutingKey {
            public static final String FOO_BAR_FIZZ = "foo.bar.fizz";

            RoutingKey(){}
        }
    }




}