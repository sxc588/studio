package  com.github.cbb.utils.json;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.fkjava.domain.User;
import org.junit.Test;
import com.github.cbb.utils.JSONUtil;

public class JSONUtilTest
{

	@Test
	public void test() throws IOException
	{
		User us = new User();
		us.setId("123");

		List<User> kList = new ArrayList<User>();
		kList.add(us);
		kList.add(us);

		String json = JSONUtil.toJson(kList);

		System.err.println(json);

		List<User> kList2 = JSONUtil.toList(json, User.class);

		assertEquals(kList2.size(), kList.size());
		System.err.println(kList2);
	}
	
	
	@Test
	public void testBean() throws IOException
	{
		User us = new User();
		us.setId("123");

		String json = JSONUtil.toJson(us);

		System.err.println(json);

		User kList2 = JSONUtil.fromJson(json, User.class);

		System.err.println(kList2);
	}

}
