package com.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor
{
	ExecutorService executorService = Executors.newFixedThreadPool(10);

	public void run2()
	{
		System.out.println("Asynchronous task");
	}

	public void AsyncRun()
	{
		executorService.submit(new Runnable()
		{

			@Override
			public void run()
			{
				run2();
			}
		});
		// executorService.shutdown();
	}
}