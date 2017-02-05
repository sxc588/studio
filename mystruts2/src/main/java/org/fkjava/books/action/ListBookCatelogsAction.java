package org.fkjava.books.action;
import java.util.List;
import org.fkjava.action.JSONUtil;
import org.fkjava.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.Action;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class ListBookCatelogsAction implements Action
{
	private List<String> bookCatlogs;

	public List<String> getBookCatlogs()
	{
		return bookCatlogs;
	}

	public void setBookCatlogs(List<String> bookCatlogs)
	{
		this.bookCatlogs = bookCatlogs;
	}

	@Autowired
	BooksService booksService = new BooksService();

	@Override
	public String execute()
	{
		bookCatlogs = booksService.getCatlogs();

		String json = JSONUtil.toJson(bookCatlogs);
		System.err.println(json);
		return SUCCESS;
	}
}
