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

        }

        public class Exchange {
            Exchange(){}
            public static final String DIRECT_EXCHANGE = "directExchange";
            public static final String TOPIC_EXCHANGE = "topicExchange";
            public static final String FANOUT_EXCHANGE = "fanoutExchange";

        }

        public class Queues {
            Queues(){}
            public static final String TOPIC_QUEUE_0 = "topic-queue-0";


        }

        public class RoutingKey {
            RoutingKey(){}

            public static final String ROUTING_KEY_1 = "routingKey1";


        }
    }




}