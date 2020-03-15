package com.github.smoken.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class RedisTest3 {
//
//	https://www.cnblogs.com/dolphin0520/p/3932921.html
	@Test
	public void testExpire() {
		HttpClients
	}

//	Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
//	Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
//	Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池
//	public static ExecutorService newFixedThreadPool(int nThreads) {
//	    return new ThreadPoolExecutor(nThreads, nThreads,
//	                                  0L, TimeUnit.MILLISECONDS,
//	                                  new LinkedBlockingQueue<Runnable>());
//	}
//	public static ExecutorService newSingleThreadExecutor() {
//	    return new FinalizableDelegatedExecutorService
//	        (new ThreadPoolExecutor(1, 1,
//	                                0L, TimeUnit.MILLISECONDS,
//	                                new LinkedBlockingQueue<Runnable>()));
//	}
//	public static ExecutorService newCachedThreadPool() {
//	    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//	                                  60L, TimeUnit.SECONDS,
//	                                  new SynchronousQueue<Runnable>());
//	}
	@Test
	public void testExpire2() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}
