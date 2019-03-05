package com.github.support.utils.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://www.cnblogs.com/yaoxiaowen/p/6576898.html
 * 
 * @author Administrator
 *
 */
public class ThreadPoolExecutorFactory
{

	public static void main(String[] args)
	{
		// 同时执行的线程：2
		int corePoolSize = 2;

		// 超过60个消息任务直接拒绝并捕获异常
		int maximumPoolSize = 5;

		// 超过60个消息任务直接拒绝并捕获异常
		long keepAliveTime = 60;

		// TODO Auto-generated method stub
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				corePoolSize,
				maximumPoolSize,
				keepAliveTime,
				TimeUnit.MICROSECONDS,
				queue);

		for (int i = 0; i < 7; i++)
		{
			Runnable task = new CustomTask(i);
			pool.execute(task);
		}

		pool.shutdown();
	}

}
