import java.util.List;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 * 服务器端拦截器
 */
public class JaxrsAuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>
{
	public JaxrsAuthInterceptor()
	{
		// 拦截器在调用方法之前拦截SOAP消息
		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault
	{
		System.out.println("come to auth interceptor...");
		// 获取SOAP消息的所有Header
		List<Header> headers = msg.getHeaders();

		if (headers == null || headers.size() < 1) { throw new Fault(new IllegalArgumentException("没有Header,拦截器实施拦截")); }
		// 获取Header携带是用户和密码信息
		Header firstHeader = headers.get(0);
		Element element = (Element) firstHeader.getObject();

		NodeList userNameElement = element.getElementsByTagName("userName");
		NodeList passwordElement = element.getElementsByTagName("password");

		if (userNameElement.getLength() != 1) { throw new Fault(new IllegalArgumentException("用户名格式不对")); }

		if (passwordElement.getLength() != 1) { throw new Fault(new IllegalArgumentException("用户密码格式不对")); }

		// 获取元素的文本内容
		String userName = userNameElement.item(0).getTextContent();
		String password = passwordElement.item(0).getTextContent();

		// 实际项目中, 应该去查询数据库, 该用户名,密码是否被授权调用该webservice
		if (!userName.equals("zhangsan") || !password.equals("123456")) { throw new Fault(new IllegalArgumentException(
				"用户名或密码不正确")); }
	}

}
