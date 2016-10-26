package com.thread;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyBatiaExecutor
{
	AsyncExecutor async = new AsyncExecutor();
	
	@Test
	public void test()
	{
		async.AsyncRun();
	}

}
