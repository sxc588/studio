

import javax.jms.Destination;
import javax.jms.JMSException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huawei.support.systemconfig.jms.model.MyMessage;
import com.huawei.support.systemconfig.jms.service.ProducerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-jms.xml")
public class ProducerConsumerTest01
{

	@Autowired
	private ProducerService producerService;

	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;

	@Test
	public void testSend()
	{
		for (int i = 1000; i < 2000; i++)
		{
			producerService.sendMessage(destination, "你好，生产者！这是队列消息：" + (i + 1));
		}
	}
	
	@Test
	public void testSend2() throws JMSException
	{
		Destination queue = producerService.createQueue("queue");
		
		for (int i = 100; i < 1000; i++)
		{
			producerService.sendMessage(queue,"你好，生产者！这是队列消息：" + (i + 1));
		}
	}
	
	@Test
	public void testSendObject() throws JMSException
	{
		Destination queue = producerService.createQueue("queue");
		
		for (int i = 1000; i < 2000; i++)
		{
			MyMessage msg = new MyMessage();
			msg.setUsername("你好，生产者！这是队列消息：" + (i + 1));
			producerService.sendMessage(queue, msg);
		}
	}

}
