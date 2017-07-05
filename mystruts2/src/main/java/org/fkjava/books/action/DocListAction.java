package org.fkjava.books.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.fkjava.domain.DocUIBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.github.cbb.action.BaseAcion;
import com.github.cbb.jaxb.JaxbUtil;
import com.github.cbb.json.JSONUtil;
import com.github.cbb.security.CodexCCUtils;


/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class DocListAction extends BaseAcion
{

	Logger logger = LoggerFactory.getLogger(DocListAction.class);
	/**
	 * 添加作者：Administrator 添加时间：2017年5月12日 上午12:04:38
	 */
	private static final long serialVersionUID = 1L;
	private List<DocUIBean> docs;

	public List<DocUIBean> getDocs()
	{
		return this.docs;
	}

	public void setDocs(List<DocUIBean> docs)
	{
		this.docs = docs;
	}

	@Autowired
	CMService CMService;

	@Override
	public String execute()
	{
		docs = CMService.getDocs();
		return SUCCESS;
	}

	public String getEOS()
	{
		docs = CMService.getDocs();
		return SUCCESS;
	}

	public String getLearnStaffDocs()
	{
		docs = CMService.getDocs();
		return SUCCESS;
	}

	public String getVversionDocs()
	{
		docs = CMService.getDocs();
		return SUCCESS;
	}

	public void getRersionDocs()
	{
		docs = CMService.getDocs();
	}

	public String getCVersionDocs()
	{
		docs = CMService.getDocs();
		return SUCCESS;
	}

	public void getPublicDocs()
	{
		long timeBegin = System.currentTimeMillis();
		
		docs = CMService.getDocs();


		//String utf8 = URLEncoder.encode(json,"utf-8");
		response.setCharacterEncoding("UTF-8");

		response.setContentType("application/json; charset=utf-8");
		PrintWriter outpw = null;
		try
		{
			outpw = response.getWriter();
			String json = JSONUtil.toJson(docs);
			outpw.write(json);
		}
		catch (IOException e)
		{
			CodexCCUtils.report(logger, "output json to response encount IOException", e);
		}
		finally
		{
			IOUtils.closeQuietly(outpw);
			logger.info("Leave Function. elapse {} ms", System.currentTimeMillis() - timeBegin);
		}
	}
	
	public void getPublicDocs2()
	{

		long timeBegin = System.currentTimeMillis();
		
		docs = CMService.getDocs();

		String json = JaxbUtil.convertToXml(docs.get(0));

		
		//String utf8 = URLEncoder.encode(json,"utf-8");
		response.setCharacterEncoding("UTF-8");

		response.setContentType("application/json; charset=utf-8");
		PrintWriter outpw = null;
		try
		{
			outpw = response.getWriter();
			outpw.write(json);
		}
		catch (IOException e)
		{
			CodexCCUtils.report(logger, "output json to response encount IOException", e);
		}
		finally
		{
			IOUtils.closeQuietly(outpw);
			logger.info("Leave Function. elapse {} ms", System.currentTimeMillis() - timeBegin);
		}
	}


}
