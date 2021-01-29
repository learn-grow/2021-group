package com.geoup.springboot.configuration.disruptor;

import com.geoup.springboot.configuration.disruptor.factory.DisruptorFactory;
import com.geoup.springboot.configuration.disruptor.model.EventModel;
import com.geoup.springboot.configuration.disruptor.producer.DisProducer;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: lisy
 * @version: DisruptorConfiguration , v0.1 2021年01月29日 16:41
 * @remark：DisruptorConfiguration
 */
@Component
public class DisruptorConfiguration {

    public static DisProducer disProducer;

    public static RingBuffer<EventModel> ringBuffer;

    @Bean
    public static DisProducer disProducer() {
        DisruptorFactory factory = DisruptorFactory.getInstance();
        ringBuffer = factory.disruptor.getRingBuffer();
        disProducer = new DisProducer(ringBuffer);
        return disProducer;
    }
}
