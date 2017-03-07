package org.fkjava.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.fkjava.domain.Xueli;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.Action;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class MainAction extends ActionBase
{
	private static final long serialVersionUID = 1L;

	@Override
	public String execute()
	{

		String upload = application.getRealPath("upload");
		// 使用application
		request.getRemoteAddr(); // 使用request
		response.getContentType(); // 使用response
		session.get("account"); // 使用Session
		return Action.SUCCESS;
	}

	public void getHeadHtml()
	{
		PrintWriter pw = null;
		try
		{
			
			response.setContentType("text/html;charset=utf-8");

			pw = super.response.getWriter();
			String abcd = "<h1>dddddddddddddddddddddddddddddd</h1>hghggh 中国";
			pw.write(abcd);
			pw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(pw);
		}
	}
	
	public void alert()
	{

		PrintWriter pw = null;
		try
		{
			//response.setContentType("text/html;charset=utf-8");
			response.setContentType("text/html"); 
			response.setHeader("Cache-Control","no-cache"); 
			request.setCharacterEncoding("UTF-8"); 
			response.setCharacterEncoding("UTF-8"); 
			pw = super.response.getWriter();
			pw.write("<script language='javascript'>alert('登陆成功');</script>");
			pw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(pw);
		}
	}
	
	public void getFootHtml()
	{

		PrintWriter pw = null;
		try
		{
			//response.setContentType("text/html;charset=utf-8");
			response.setContentType("text/html"); 
			response.setHeader("Cache-Control","no-cache"); 
			request.setCharacterEncoding("UTF-8"); 
			response.setCharacterEncoding("UTF-8"); 
			pw = super.response.getWriter();
			pw.write("<script language='javascript'>alert('登陆成功');</script>");
			pw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(pw);
		}
	}
}
