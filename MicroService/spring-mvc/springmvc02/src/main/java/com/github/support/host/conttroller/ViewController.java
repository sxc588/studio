package com.github.support.host.conttroller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hwpf.extractor.Word6Extractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
//import org.apache.poi.hslf.HSLFSlideShow;
//import org.apache.poi.hslf.model.Slide;
//import org.apache.poi.hslf.model.TextRun;
//import org.apache.poi.hslf.usermodel.SlideShow;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * apache poi操作office文档----java在线预览txt、word、ppt、execel，pdf代码 2015年05月26日
 * 21:33:51
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("view/")
public class ViewController
{
	private static Logger logger = LoggerFactory.getLogger(ViewController.class);
	private String urlReal = "file:///d:/新建 Microsoft Word 文档.docx";

	@RequestMapping(value = "/word", method = RequestMethod.GET)
	public void word(HttpServletRequest request, HttpServletResponse response) throws IOException
	{

		BufferedInputStream bis = null;
		URL url = null;
		HttpURLConnection httpUrl = null; // 建立链接
	//	url = new URL(urlReal);
	//	httpUrl = (HttpURLConnection) url.openConnection();// 连接指定的资源
	//	httpUrl.connect();// 获取网络输入流
	//	bis = new BufferedInputStream(httpUrl.getInputStream());
		
		
		bis = new BufferedInputStream(new FileInputStream("d:/新建 Microsoft Word 文档.docx"));
		
		
		String bodyText = null;
		Word6Extractor ex = new Word6Extractor(bis);
		bodyText = ex.getText();
		response.getWriter().write(bodyText);

	}

	@RequestMapping("/excell")
	public void excell(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		BufferedInputStream bis = null;
		URL url = null;
		HttpURLConnection httpUrl = null; // 建立链接
//		url = new URL(urlReal);
//		httpUrl = (HttpURLConnection) url.openConnection();// 连接指定的资源
//		httpUrl.connect();// 获取网络输入流
//		
		
		bis = new BufferedInputStream(new FileInputStream("d:/xx.xlsx"));
		
		
		//bis = new BufferedInputStream(httpUrl.getInputStream());
		StringBuffer content = new StringBuffer();
		XSSFWorkbook workbook = new XSSFWorkbook(bis);
		for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++)
		{
			XSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
			content.append("/n");
			if (null == aSheet)
			{
				continue;
			}
			for (int rowNum = 0; rowNum <= aSheet.getLastRowNum(); rowNum++)
			{
				content.append("/n");
				XSSFRow aRow = aSheet.getRow(rowNum);
				if (null == aRow)
				{
					continue;
				}
				for (short cellNum = 0; cellNum <= aRow.getLastCellNum(); cellNum++)
				{
					XSSFCell aCell = aRow.getCell(cellNum);
					if (null == aCell)
					{
						continue;
					}
					if (aCell.getCellType() == XSSFCell.CELL_TYPE_STRING)
					{
						content.append(aCell.getRichStringCellValue().getString());
					} else if (aCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{
						boolean b = HSSFDateUtil.isCellDateFormatted(aCell);
						if (b)
						{
							Date date = aCell.getDateCellValue();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							content.append(df.format(date));
						}
					}
				}
			}
		}
		response.getWriter().write(content.toString());

	}

	@RequestMapping("/ppt")
	public void ppt(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
//		BufferedInputStream bis = null;
//		URL url = null;
//		HttpURLConnection httpUrl = null; // 建立链接
//		url = new URL(urlReal);
//		httpUrl = (HttpURLConnection) url.openConnection();// 连接指定的资源
//		httpUrl.connect();// 获取网络输入流
//		bis = new BufferedInputStream(httpUrl.getInputStream());
//		StringBuffer content = new StringBuffer("");
//		SlideShow ss = new SlideShow(new HSLFSlideShow(bis));
//		Slide[] slides = ss.getSlides();
//		for (int i = 0; i < slides.length; i++)
//		{
//			TextRun[] t = slides[i].getTextRuns();
//			for (int j = 0; j < t.length; j++)
//			{
//				content.append(t[j].getText());
//			}
//			content.append(slides[i].getTitle());
//		}
//		response.getWriter().write(content.toString());
	}

	@RequestMapping("/pdf")
	public void pdf(HttpServletRequest request, HttpServletResponse response)
	{
		// BufferedInputStream bis = null;
		// URL url = null;
		// HttpURLConnection httpUrl = null; // 建立链接
		// url = new URL(urlReal);
		// httpUrl = (HttpURLConnection) url.openConnection();// 连接指定的资源
		// httpUrl.connect();// 获取网络输入流
		// bis = new BufferedInputStream(httpUrl.getInputStream());
		// PDDocument pdfdocument = null;
		// PDFParser parser = new PDFParser(bis);
		// parser.parse();
		// pdfdocument = parser.getPDDocument();
		// ByteArrayOutputStream out = new ByteArrayOutputStream();
		// OutputStreamWriter writer = new OutputStreamWriter(out);
		// PDFTextStripper stripper = new PDFTextStripper();
		// stripper.writeText(pdfdocument.getDocument(), writer);
		// writer.close();
		// byte[] contents = out.toByteArray();
		// String ts = new String(contents);
		// response.getWriter().write(ts);
	}

	@RequestMapping("/txt")
	public void txt(HttpServletRequest request, HttpServletResponse response) throws IOException
	{

		BufferedReader bis = null;
		URL url = null;
		HttpURLConnection httpUrl = null; // 建立链接
		url = new URL(urlReal);
		httpUrl = (HttpURLConnection) url.openConnection();// 连接指定的资源
		httpUrl.connect();// 获取网络输入流
		bis = new BufferedReader(new InputStreamReader(httpUrl.getInputStream()));
		StringBuffer buf = new StringBuffer();
		String temp;
		while ((temp = bis.readLine()) != null)
		{
			buf.append(temp);
			response.getWriter().write(temp);
			if (buf.length() >= 1000)
			{
				break;
			}
		}
		bis.close();
	}
	
	

	@RequestMapping("/hh")
	public void hh(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// String path = request.getContextPath();  
		// String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  

//	        request.getContextPath()，得到工程名：/dmsd-itoo-exam-log-web；
//
//	        request.getServletPath()，返回当前页面所在目录下全名称：/course/index.jsp；
//
//	        request.getRequestURL()，返回IE地址栏地址：http://localhost:8080/dmsd-itoo-exam-log-web/course/index.jsp；
//
//	        request.getRequestURI() ，返回包含工程名的当前页面全路径：/dmsd-itoo-exam-log-web/course/index.jsp。
//		ServletContext context = request.getServletContext();
//		
//		InputStream tt = context.getResourceAsStream("check_status.jsp");
//		if (null == tt)
//		{
//			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
		
		request.getRequestDispatcher("check_status.jsp").forward(request, response);
	}
}