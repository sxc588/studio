package org.fkjava.books.action;
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
public class GetBooksByCategoryAction implements Action
{
	
	private String category;
	
	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public List<Book> getBooks()
	{
		return books;
	}

	public void setBooks(List<Book> books)
	{
		this.books = books;
	}

	private List<Book> books;


	@Autowired
	BooksService booksService = new BooksService();

	@Override
	public String execute()
	{
		books = booksService.getBooksByCategory(category);

		String json = JSONUtil.toJson(books);
		System.err.println(json);
		return SUCCESS;
	}

}
