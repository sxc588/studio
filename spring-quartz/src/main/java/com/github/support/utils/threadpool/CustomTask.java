package com.github.support.utils.threadpool;

import java.util.concurrent.TimeUnit;

class CustomTask implements Runnable
{
	private int id;
	public CustomTask(int id)
	{
		this.id = id;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println("#" + id + "   threadId=" + Thread.currentThread().getName());
		try
		{
			TimeUnit.MILLISECONDS.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
