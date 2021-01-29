package com.geoup.springboot.configuration.disruptor.handler.impl;

import com.geoup.springboot.annotations.DisruptorHandler;
import com.geoup.springboot.configuration.disruptor.model.EventModel;
import com.geoup.springboot.configuration.disruptor.handler.AbstractHandler;
import com.geoup.springboot.utils.JsonUtils;

/**
 * @author: lisy
 * @version: PayHandler , v0.1 2021年01月29日 15:58
 * @remark：PayHandler
 */
@DisruptorHandler
public class PayHandler extends AbstractHandler {

    @Override
    public void onEvent(EventModel event, long sequence, boolean endOfBatch){
        if (event.getVersion().endsWith("1.0")){
            System.out.println(JsonUtils.toJson(event));
        }
    }
}
