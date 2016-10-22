

import javax.jms.Destination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.huawei.support.systemconfig.jms.service.ProducerService;

//http://haohaoxuexi.iteye.com/blog/1893676
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProducerConsumerTest
{
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	@Qualifier("sessionAwareQueue")
	private Destination sessionAwareQueue;

	@Test
	public void testSessionAwareMessageListener()
	{
		producerService.sendMessage(sessionAwareQueue, "测试SessionAwareMessageListener");
	}

}
