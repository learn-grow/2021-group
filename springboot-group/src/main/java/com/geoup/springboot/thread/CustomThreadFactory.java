package com.geoup.springboot.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lisy
 * @version: CreditThreadFactory , v0.1 2021年01月04日 17:29
 * @remark：CreditThreadFactory
 */
public class CustomThreadFactory implements ThreadFactory {

    private final AtomicInteger poolNumber = new AtomicInteger();

    private final ThreadGroup threadGroup;

    private final AtomicInteger threadNumber = new AtomicInteger();

    public final String namePrefix;

    public CustomThreadFactory(String name){
        SecurityManager securityManager = System.getSecurityManager();
        threadGroup = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (null == null || "".equals(name.trim())){
            name = "pool";
        }
        namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(threadGroup , r , namePrefix + threadNumber.getAndIncrement() , 0);
        if (t.isDaemon()){
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY){
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
