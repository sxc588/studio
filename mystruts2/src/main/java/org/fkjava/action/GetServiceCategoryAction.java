package org.fkjava.action;
import java.util.List;
import org.fkjava.books.service.BooksService;
import org.fkjava.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.github.cbb.utils.JSONUtil;
import com.opensymphony.xwork2.Action;

/**
 * Action 满足三个要求：
 *  1. 实现Action 接口，或 继承ActionSupport【推荐继承】
 *  2. 数据fild , 提供 setter，getter 方法 
 *  3. 无构造参数的构造器
 */
@Controller
public class GetServiceCategoryAction implements Action
{
	
	private String category;
	
	private List<ServiceInfo> micService;

	@Autowired
	VirutalMechineService booksService;

	@Override
	public String execute()
	{
		
		return SUCCESS;
	}

}
