package com.filipe.domain.event;

import java.io.Serializable;

public class SimpleMessage implements Serializable {

    private String origin;
    private String destine;
    private String content;

    private String topic;

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

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "origin='" + origin + '\'' +
                ", destine='" + destine + '\'' +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}