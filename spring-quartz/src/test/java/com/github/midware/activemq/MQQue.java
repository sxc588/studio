package com.github.midware.activemq;

import static org.junit.Assert.*;

import org.junit.Test;

public class MQQue implements Comparable<MQQue> {

	private String name;// 消息队列名称
	private long queueSize;// 队列中剩余的消息数
	private long consumerCount;// 消费者数
	private long dequeueCount;// 出队数
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getQueueSize() {
		return queueSize;
	}
	public void setQueueSize(long queueSize) {
		this.queueSize = queueSize;
	}
	public long getConsumerCount() {
		return consumerCount;
	}
	public void setConsumerCount(long consumerCount) {
		this.consumerCount = consumerCount;
	}
	public long getDequeueCount() {
		return dequeueCount;
	}
	public void setDequeueCount(long dequeueCount) {
		this.dequeueCount = dequeueCount;
	}
	@Override
	public int compareTo(MQQue o1) {
		// TODO Auto-generated method stub
		long res=this.getQueueSize()-o1.getQueueSize();
		if(res>0) return 1;
		else if(res<0) return -1;
		else return 0;
	}
	
	
}
————————————————
版权声明：本文为CSDN博主「龙飞云跃」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_36556651/article/details/99771909