package com.geoup.springboot.configuration.disruptor.producer;

import com.geoup.springboot.configuration.disruptor.model.EventModel;
import com.geoup.springboot.utils.JsonUtils;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import org.springframework.beans.BeanUtils;

import java.nio.ByteBuffer;

/**
 * @author: lisy
 * @version: DisProducer , v0.1 2021年01月29日 16:38
 * @remark：DisProducer
 */
public class DisProducer {

    public final RingBuffer<EventModel> ringBuffer;

    private static final EventTranslatorOneArg<EventModel, ByteBuffer> TRANSLATOR = new EventTranslatorOneArg<EventModel, ByteBuffer>() {
        @Override
        public void translateTo(EventModel event, long sequence, ByteBuffer bb) {
            BeanUtils.copyProperties(JsonUtils.bufferToBean(bb, EventModel.class), event);
        }
    };

    public DisProducer(RingBuffer<EventModel> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer) {
        ringBuffer.publishEvent(TRANSLATOR, buffer);
    }

}
