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

        public class Exchange {
            Exchange(){}
            public static final String DIRECT_EXCHANGE = "directExchange";
            public static final String TOPIC_EXCHANGE = "topicExchange";
            public static final String DL_TOPIC_EXCHANGE = "dLTopicExchange";
            public static final String FANOUT_EXCHANGE = "fanoutExchange";


        }

        public class Queues {
            Queues(){}
            public static final String TOPIC_QUEUE = "topicQueue";
            public static final String DL_QUEUE = "deadLetterQueue";
            public static final String TOPIC_QUEUE_0 = "topic-queue-0";

        }

        public class RoutingKey {
            RoutingKey(){}
            public static final String ROUTING_KEY_1 = "routingKey1";
            public static final String ROUTING_KEY_DEAD_LETTER = "routingKeyDeadLetter";
        }
    }




}