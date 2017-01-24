package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.JdbcTemplate;
import com.wangwang.entity.BookInfo;
import com.wangwang.mapping.BookInfoMapping;

public class BookInfoDAO {
	private JdbcTemplate jdbc = new JdbcTemplate();

	/**
	 * 新增
	 * 
	 * @param bookInfo
	 * @return
	 */
	public boolean save(BookInfo bookInfo) {
		String pbDate = Tool.conventDateToString(bookInfo.getPbDate());
		String sql = "insert into bookInfo(bookName,booktypeId,pbName,author,"
				+ "context,price,pbdate,ygcprice,bigImg,smallImg, bookStates)" + "values"
				+ "(?,?,?,?,?,?,?,?, ?, ?, ?)";
		Object[] values = new Object[] { bookInfo.getBookName(),
				bookInfo.getBookTypeId(), bookInfo.getPbName(),
				bookInfo.getAuthor(), bookInfo.getContext(),
				bookInfo.getPrice(), pbDate, bookInfo.getYgcPrice(),
				bookInfo.getBigImg(), bookInfo.getSmallImg(), bookInfo.getBookStates()};
		int rows = 0;
		try {
			rows = jdbc.update(sql, values);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return (rows == 1);
	}

	/**
	 * 修改
	 * 
	 * @param bookType
	 * @return
	 */
	public boolean update(BookInfo bookInfo) {
		String pbDate = Tool.conventDateToString(bookInfo.getPbDate());
		String sql = " update bookInfo set "
				+ "	bookName=?,bookTypeId=?,pbName=?,author=?,context=?,"
				+ "	price=?,pbDate=?,ygcPrice=?,smallImg=?,bigImg=?,bookStates= ? "
				+ " where" + "	 bookId=?";
		Object[] values = new Object[] { bookInfo.getBookName(),
				bookInfo.getBookTypeId(), bookInfo.getPbName(),
				bookInfo.getAuthor(), bookInfo.getContext(),
				bookInfo.getPrice(), pbDate, bookInfo.getYgcPrice(),
				bookInfo.getSmallImg(), bookInfo.getBigImg(),bookInfo.getBookStates(),
				bookInfo.getBookId()};
		int rows = 0;
		try {
			rows = jdbc.update(sql, values);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return (rows == 1);
	}

	public boolean updateImg(String imgA, String imgB, int id) {
		String sql = "update bookInfo set smallImg=?,bigImg=? where bookId=?";
		Object[] vlaues = new Object[] { imgA, imgB, id };
		int rows = 0;
		try {
			rows = jdbc.update(sql, vlaues);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return (rows == 1);
	}

	/**
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateStates(int states, int id) {
		String sql = "update bookInfo set bookStates = ? where bookId = ?";
		int rows = 0;
		try {
			rows = jdbc.update(sql, states, id);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}

		return (rows == 1);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		String sql = "delete from bookinfo where bookId=" + id;
		try {
			return (jdbc.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return false;
	}
	
	public int getPageCount(int pageSize, int states) {
		int pageCount = 0;
		String haha = 
			" select " + 
			"	count(*) " + 
			" from " + 
			"	bookinfo" +
			" where bookStates ";
		StringBuffer sql = new StringBuffer(haha);
		switch (states) {
		case 4:
			sql.append(" <> 3 ");
			break;
		case 5:
			sql.append(" <> 4 ");
			break;
		default:
			sql.append(" = " + states);
		}
		try {
			int rowCount = jdbc.query(sql.toString());
			pageCount = rowCount / pageSize;
			if (rowCount % pageSize != 0) {
				pageCount ++;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageCount;
	}
	
	public List<BookInfo> getNowPageData(int nowPage, int pageSize, int states) {
		StringBuffer where  = new StringBuffer(" where bookStates ");
		switch (states) {
		case 4:
			where.append(" <> 3 ");
			break;
		case 5:
			where.append(" <> 4 ");
			break;
		default:
			where.append(" = " + states);
		}
		String sql = 
			" select " + 
			"	top " + pageSize + 
			"	bookId,bookName,bookTypeId,pbName,author," + 
			"   context,smallImg,bigImg,price,pbDate," + 
			"	ygcPrice,bookStates " + 
			" from " + 
			"	bookinfo" + where + 
			" and " +
			"	bookId not in" +
			"		(select top " + (nowPage-1)*pageSize + " bookId from bookInfo  " + where + 
			"		) ";
			
		 
	
		List<BookInfo> bookInfos = null;
		try {
			bookInfos = jdbc.query(sql.toString(), new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return bookInfos;
	}
	/**
	 * 
	 * @param states 1, 2, 3, 4所有可用的  5 所有的吧
	 * @return
	 */
	public List<BookInfo> findAll(int states) {
		String haha = 
			" select " + 
			"	bookId,bookName,bookTypeId,pbName,author," + 
			"   context,smallImg,bigImg,price,pbDate," + 
			"	ygcPrice,bookStates " + 
			" from " + 
			"	bookinfo" +
			" where bookStates ";
		StringBuffer sql = new StringBuffer(haha);
		switch (states) {
		case 4:
			sql.append(" <> 3 ");
			break;
		case 5:
			sql.append(" <> 4 ");
			break;
		default:
			sql.append(" = " + states);
		}
		System.out.println(sql);
		List<BookInfo> bookInfos = null;
		try {
			bookInfos = jdbc.query(sql.toString(), new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return bookInfos;
	}
	/**
	 * 查询全部
	 * 
	 * @param booktype
	 * @return
	 */
	public List<BookInfo> findAll() {
		String sql = " select " + "	bookId,bookName,bookTypeId,pbName,author,"
				+ " context,smallImg,bigImg,price,pbDate,"
				+ "	ygcPrice,bookStates " + " from " + "	bookinfo";
		List<BookInfo> bookInfos = null;
		try {
			bookInfos = jdbc.query(sql, new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return bookInfos;
	}

	/**
	 * 查询一条id
	 * @param id
	 * @return
	 */
	public BookInfo findById(int id) {
		String sql = 
			" select " + 
			"	bookId,bookName,bookTypeId,pbName,author," + 
			" context,smallImg,bigImg,price,pbDate," + 
			"	ygcPrice,bookStates " + 
			" from " + 
			"	bookinfo where bookId="+id;
		 BookInfo  bookInfo = null;
		try {
//			List entitys = jdbc.query(sql, new BookInfoMapping());
//			bookInfo = (BookInfo) entitys.get(0);
			//上边的简写
			bookInfo = (BookInfo) jdbc.query(sql, new BookInfoMapping()).get(0);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return bookInfo;
	}
}
