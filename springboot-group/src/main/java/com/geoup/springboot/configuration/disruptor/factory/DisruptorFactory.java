package com.geoup.springboot.configuration.disruptor.factory;

import com.geoup.springboot.SpringbootGroupApplication;
import com.geoup.springboot.annotations.DisruptorHandler;
import com.geoup.springboot.configuration.disruptor.model.EventModel;
import com.geoup.springboot.configuration.disruptor.handler.AbstractHandler;
import com.geoup.springboot.thread.CustomThreadFactory;
import com.geoup.springboot.utils.ApplicationContextProvider;
import com.geoup.springboot.utils.MyClassLoader;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: lisy
 * @version: DisruptorFactory , v0.1 2021年01月29日 15:41
 * @remark：DisruptorFactory
 */
@Slf4j
public class DisruptorFactory {

    private static final String BASE_PACKAGE = "com.geoup.springboot.configuration.disruptor.handler.impl";

    private static volatile DisruptorFactory disruptorFactory;

    /**
     * 初始化默认的buffer 大小
     */
    public static int ringBufferSize = 1024;

    public static EventModelInstance modelInstance;

    public static ThreadPoolExecutor executor;

    public static Disruptor<EventModel> disruptor;

    public static List<AbstractHandler> handlers = new ArrayList<>();

    public static DisruptorFactory getInstance() {
        if (null == disruptorFactory) {
            synchronized (DisruptorFactory.class) {
                disruptorFactory = new DisruptorFactory();
            }
        }
        return disruptorFactory;
    }


    /**
     * 实例化对象
     */
    public DisruptorFactory() {
        initDisruptor();
    }

    /**
     * 初始化 disruptor
     */
    private static Disruptor<EventModel> initDisruptor() {
        initThreadPool();
        initHandler();
        modelInstance = new EventModelInstance();
        disruptor = new Disruptor<EventModel>(modelInstance, ringBufferSize, executor, ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWith(handlers.get(0));
        disruptor.start();
        log.info("start the disruptor success !");
        return disruptor;
    }

    /**
     * 初始化handler
     */
    private static void initHandler() {
        ApplicationContext applicationContext = new ApplicationContextProvider().getApplicationContext();
        Class<?>[] classes = MyClassLoader.getClazz(BASE_PACKAGE, applicationContext);
        for (Class<?> zclass : classes) {
            DisruptorHandler disruptorHandler = zclass.getAnnotation(DisruptorHandler.class);
            if (null != disruptorHandler) {
                try {
                    AbstractHandler abstractHandler = (AbstractHandler) zclass.newInstance();
                    handlers.add(abstractHandler);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("disruptor handler success !~");
    }

    /**
     * 初始化 线程池信息
     */
    private static void initThreadPool() {
        executor = new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(200), new CustomThreadFactory("disruptor"));
        log.info("disruptor thread pool creaded success !~");
    }
}

/**
 * event model 对象工厂
 **/
class EventModelInstance implements EventFactory<EventModel> {

    @Override
    public EventModel newInstance() {
        return new EventModel();
    }
}
