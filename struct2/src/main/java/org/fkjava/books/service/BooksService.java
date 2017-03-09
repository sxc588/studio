package org.fkjava.books.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.fkjava.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BooksService
{
	static Map<String,List<Book>> booksDb;
	static
	{
		booksDb = new HashMap<String, List<Book>>();
		
		List<Book> books1 = new ArrayList<Book>();
	
		books1.add(new Book("90001", "疯狂java", "sxc", 86.8f));
		books1.add(new Book("90002", "疯狂Android", "sxc", 86.8f));
		books1.add(new Book("90003", "疯狂Ajax", "sj", 76.8f));
		books1.add(new Book("90004", "疯狂 Dw", "nx", 79.8f));
		booksDb.put("计算机类", books1);
		
		List<Book> books2 = new ArrayList<Book>();
		books2.add(new Book("80001", "西游记", "吴承恩", 86.8f));
		books2.add(new Book("80002", "红楼梦", "曹雪芹", 86.8f));
		books2.add(new Book("80003", "水浒", "施耐庵", 76.8f));
		books2.add(new Book("80004", "三国演义", "不知道", 79.8f));
		booksDb.put("小说类", books2);
	}

	public Map<String, List<Book>> getAll()
	{
		return booksDb;
	}

	public List<String> getCatlogs()
	{
		//set create and set some value
		Set<String> catlogSet = booksDb.keySet();

        //create array with set.size,then get value from set
        String[] array = (String[]) catlogSet.toArray(new String[catlogSet.size()]);

        return Arrays.asList(array);
	}

	public List<Book> getBooksByCategory(String category)
	{
		return booksDb.get(category);
	}
}
