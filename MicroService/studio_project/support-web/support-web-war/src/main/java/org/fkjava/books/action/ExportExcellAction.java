package org.fkjava.books.action;
import java.io.InputStream;
import org.fkjava.books.service.IExcelService;
import org.fkjava.books.service.impl.ExcelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.Action;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class ExportExcellAction implements Action
{
	private InputStream excelStream;

	public InputStream getExcelStream()
	{
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream)
	{
		this.excelStream = excelStream;
	}

	@Autowired
	ExcelServiceImpl es = new ExcelServiceImpl();

	@Override
	public String execute()
	{
		excelStream = es.getExcelInputStream();
		return "excel";
	}
}
