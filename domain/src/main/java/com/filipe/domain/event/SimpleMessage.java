package com.filipe.domain.event;

import java.io.Serializable;

public class SimpleMessage implements Serializable {

    private String origin;
    private String destine;
    private String content;
    private String topic;
    private String exchange;
    private String routingKey;
    private String queue;

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestine() {
        return destine;
    }

    public void setDestine(String destine) {
        this.destine = destine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "origin='" + origin + '\'' +
                ", destine='" + destine + '\'' +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", exchange='" + exchange + '\'' +
                ", routingKey='" + routingKey + '\'' +
                ", queue='" + queue + '\'' +
                '}';
    }
}