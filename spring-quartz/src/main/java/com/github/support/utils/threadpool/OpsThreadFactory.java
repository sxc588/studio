package com.github.support.utils.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class OpsThreadFactory implements ThreadFactory
{
	private AtomicInteger counter = new AtomicInteger(1);

	private boolean isDeamon;

	private String name;

	private String model;

	public OpsThreadFactory(String name, String model,boolean isDeamon)
	{
		super();
		this.isDeamon = isDeamon;
		this.name = name;
		this.model = model;
	}

	public OpsThreadFactory(String name, String model)
	{
		super();
		this.name = name;
		this.model = model;
	}

	@Override
	public Thread newThread(Runnable r)
	{
		String threadId = model + "_" + name + "_" + counter.incrementAndGet();
		Thread thread = new Thread(r, threadId);
		thread.setDaemon(isDeamon);
		return thread;
	}
}
