package com.geoup.springboot.configuration.disruptor.model;

import lombok.Data;

/**
 * @author: lisy
 * @version: EventModel , v0.1 2021年01月29日 14:57
 * @remark：EventModel
 */
@Data
public class EventModel {

    private String version = "DIS_1.0";

    private EventEnum eventEnum;

    private String data;

    public EventModel(){}

    public EventModel(String data , EventEnum eventEnum) {
        this.data = data;
        this.eventEnum = eventEnum;
    }
}
