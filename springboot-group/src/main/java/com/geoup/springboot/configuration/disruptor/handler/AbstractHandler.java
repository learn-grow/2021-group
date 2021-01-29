package com.geoup.springboot.configuration.disruptor.handler;

import com.geoup.springboot.configuration.disruptor.model.EventModel;
import com.lmax.disruptor.EventHandler;

/**
 * @author: lisy
 * @version: AbstractHandler , v0.1 2021年01月29日 15:56
 * @remark：AbstractHandler
 */
public abstract class AbstractHandler implements EventHandler<EventModel>{

    @Override
    public abstract void onEvent(EventModel model, long sequence, boolean endOfBatch);
}
