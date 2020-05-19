package com.github.smoken.thread;

public class MyTask implements Runnable {

	private int taskNum;

	public MyTask(int num) {
		this.taskNum = num;
	}

	@Override
	public void run() {

		 System.err.println("正在执行task " + taskNum);
		try {
			// Thread.currentThread();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		 System.err.println("task " + taskNum + "执行完毕");
	}
}
