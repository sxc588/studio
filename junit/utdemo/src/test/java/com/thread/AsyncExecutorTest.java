package com.thread;

import static org.junit.Assert.*;

import org.junit.Test;

public class AsyncExecutorTest
{
	AsyncExecutor async = new AsyncExecutor();
	
	@Test
	public void test()
	{
		async.AsyncRun();
	}

}
