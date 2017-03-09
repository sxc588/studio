import java.util.List;
import javax.xml.namespace.QName;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JaxrsAddHeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage>
{
	private String userName;
	private String password;

	public JaxrsAddHeaderInterceptor(String userName, String password)
	{
		super(Phase.PREPARE_SEND);
		this.userName = userName;
		this.password = password;
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault
	{
		List<Header> headers = msg.getHeaders();

		// 创建Document对象
		Document document = DOMUtils.createDocument();
		Element element = document.createElement("authHeader");

		// 配置服务器端Head信息的用户密码
		Element userNameElement = document.createElement("userName");
		userNameElement.setTextContent(userName);
		Element passwordElement = document.createElement("password");
		passwordElement.setTextContent(password);

		element.appendChild(userNameElement);
		element.appendChild(passwordElement);
		headers.add(new Header(new QName(""), element));
		
		/**
		 * 生成的XML文档
		 * <authHeader>
		 * <userName>zhangsan</userName>
		 * <password>123456</password>
		 * </authHeader>
		 */
	}

}
