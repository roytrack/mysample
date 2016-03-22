package com.roytrack.netty.fnio2_2_2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ruanchangming on 2016/03/21.
 */
public class TimeServerHandlerExecutePool {
    private ExecutorService executor;
    TimeServerHandlerExecutePool(int maxPoolSize,int maxQueueLength){
        executor=new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(maxQueueLength));
    }
    public void execute(Runnable task){
        executor.execute(task);
    }
}
