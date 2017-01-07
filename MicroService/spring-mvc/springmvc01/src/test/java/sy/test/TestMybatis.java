package sy.test;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.github.support.entitement.mybatis.dao.BugMapper;
import com.github.support.entitement.mybatis.model.Bug;
import com.github.support.mvc.service.UserServiceI;

//import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestMybatis {

	

//	private static final Logger logger = Logger.getLogger(TestMybatis.class);
//
	@Autowired
	private BugMapper bugMapper;
//
//	public UserServiceI getUserService() {
//		return userService;
//	}
//
//	@Autowired
//	public void setUserService(UserServiceI userService) {
//		this.userService = userService;
//	}

	@Test
	public void test1() {
		Bug record = new Bug();
		Integer id = java.util.UUID.randomUUID().hashCode();
		record.setId(id.toString());
		record.setName("name");
		record.setCreatedatetime(null);
		record.setNote("new Date()");
		bugMapper.insertSelective(record );
//		User u = userSe("1");
//		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

//	@Test
//	public void test2() {
//		List<User> l = userService.getAll();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
//
//	@Test
//	public void test3() {
//		List<User> l = userService.getAll2();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
//
//	@Test
//	public void test4() {
//		List<User> l = userService.getAll3();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
}
