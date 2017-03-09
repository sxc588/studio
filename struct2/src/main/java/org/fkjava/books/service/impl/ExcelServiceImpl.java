package org.fkjava.books.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import jxl.Workbook;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.fkjava.books.service.IExcelService;
import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl implements IExcelService
{

	@Override
	public InputStream getExcelInputStream()
	{
		// 将OutputStream转化为InputStream
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		putDataOnOutputStream(out);
		return new ByteArrayInputStream(out.toByteArray());
	}

	private void putDataOnOutputStream(OutputStream os)
	{
		jxl.write.Label label;
		WritableWorkbook workbook;
		try
		{
			workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);

			for (int i = 0; i < 1000; i++)
			{
				label = new jxl.write.Label(0, i, "struts2导出excel");
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String templatePath, String outFileStr)
	{
		// String templatePath = "c://template.xls";//模板文件名
		// String outFileStr = "c://test.xls";//测试文件名(输出文件)
		try
		{
			// 创建小字体：Arial,大小为8号,非粗体，非斜体
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 8, WritableFont.NO_BOLD, false);
			// 字体颜色为红色
			wf.setColour(jxl.format.Colour.RED);
			// 创建大字体：Arial,大小为18号,粗体，非斜体
			WritableFont Bwf = new WritableFont(WritableFont.ARIAL, 18, WritableFont.NO_BOLD, false);
			Bwf.setColour(jxl.format.Colour.RED);
			// 创建单元格格式：设置水平对齐为向右对齐
			jxl.write.WritableCellFormat RwcfF = new jxl.write.WritableCellFormat(wf);
			RwcfF.setAlignment(jxl.write.Alignment.RIGHT);
			// 创建单元格格式：设置水平对齐为向左对齐
			jxl.write.WritableCellFormat LwcfF = new jxl.write.WritableCellFormat(wf);
			LwcfF.setAlignment(jxl.write.Alignment.LEFT);
			// 创建单元格格式：设置水平对齐为居中对齐
			jxl.write.WritableCellFormat CwcfF = new jxl.write.WritableCellFormat(wf);
			CwcfF.setAlignment(jxl.write.Alignment.CENTRE);
			jxl.write.WritableCellFormat CBwcfF = new jxl.write.WritableCellFormat(Bwf);
			CBwcfF.setAlignment(jxl.write.Alignment.CENTRE);
			// 设置垂直对齐为居中对齐
			CBwcfF.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 设置顶部边框线为实线(默认是黑色－－也可以设置其他颜色)
			CBwcfF.setBorder(jxl.format.Border.TOP, BorderLineStyle.MEDIUM);
			// 设置右边框线为实线
			CBwcfF.setBorder(jxl.format.Border.RIGHT, BorderLineStyle.MEDIUM);
			// 设置顶部框线为实线
			CBwcfF.setBorder(jxl.format.Border.BOTTOM, BorderLineStyle.MEDIUM);
			jxl.write.WritableCellFormat CMwcfF = new jxl.write.WritableCellFormat(wf);
			CMwcfF.setAlignment(jxl.write.Alignment.LEFT);
			// 设置垂直对齐为向上对齐
			CMwcfF.setVerticalAlignment(VerticalAlignment.TOP);
			CMwcfF.setWrap(true);
			
			
			
			
			File tFile = new File(templatePath);// 创建模板文件对象
			File outFile = new File(outFileStr);// 创建输出文件对象
			// 创建文件输出流对象
			FileOutputStream os = new FileOutputStream(outFile);
			// 模板工作簿对象
			Workbook tBook = Workbook.getWorkbook(tFile);
			// 输出工作簿对象
			WritableWorkbook wbook = Workbook.createWorkbook(os, tBook);

			WritableSheet wsheet = wbook.createSheet("Sheet1", 0);

			// 在坐标为(0,0)的单元格写入"测试"字符串使用8号红色小字体，向右对齐
			wsheet.addCell(new Label(0, 0, "test", RwcfF));
			// 在坐标为(1,1)的单元格写入"test"字符串使用8号红色小字体，向左对齐
			wsheet.addCell(new Label(1, 1, "test", LwcfF));
			// 在坐标为(2,2)的单元格写入"测试test"字符串使用8号红色小字体，居中对齐
			wsheet.addCell(new Label(2, 2, "测试test", CMwcfF));
			// 在坐标为(3,3)的单元格写入2.00使用18号红色大字体，居中对齐
			wsheet.addCell(new jxl.write.Number(23, 14, 2.00, CBwcfF));
			// 写入
			wbook.write();
			wbook.close();
			tBook.close();
			// 关闭文件输出流
			os.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
