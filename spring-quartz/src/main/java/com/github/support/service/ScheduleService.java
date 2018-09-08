package com.github.support.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.stereotype.Repository;

import com.github.support.vo.ScheduleJobVo;

@Repository
public class ScheduleService
{

	public void export(String[] titles, List<ScheduleJobVo> values, ServletOutputStream out)
	{
		try
		{

			// 第一步，创建一个workbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet hssfSheet = workbook.createSheet("sheet1");
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow hssfRow = hssfSheet.createRow(0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
			// 居中样式
			hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);

			HSSFCell hssfCell = null;
			for (int i = 0; i < titles.length; i++)
			{
				hssfCell = hssfRow.createCell(i);// 列索引从0开始
				hssfCell.setCellValue(titles[i]);// 列名1
				hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
			}

			// 第五步，写入实体数据
			DoTT(workbook, hssfSheet, values);

			// 第七步，将文件输出到客户端浏览器
			try
			{
				workbook.write(out);
				out.flush();
				out.close();

			} catch (Exception e)
			{
				e.printStackTrace();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String ISOtoGBK(String s)
	{
		String str = "";
		try
		{
			if (s == null || s == "" || s.equals(""))
			{
				str = s;
			} else
			{
				str = new String(s.getBytes("ISO8859-1"), "GBK");
			}
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	private void DoTT(HSSFWorkbook workbook, HSSFSheet hssfSheet, List<ScheduleJobVo> values)
	{


		// 第一种：日期格式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFDataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("yyyy-m-d hh:mm:ss"));

		// 第二种：保留两位小数格式
		HSSFCellStyle cellStyle2 = workbook.createCellStyle();
		cellStyle2.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));

		// 第三种：货币格式
		HSSFCellStyle cellStyle3 = workbook.createCellStyle();
		HSSFDataFormat format3 = workbook.createDataFormat();
		cellStyle3.setDataFormat(format3.getFormat("¥#,##0"));

		// 第四种：百分比格式
		HSSFCellStyle cellStyle4 = workbook.createCellStyle();
		cellStyle4.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));

		// 第五种：中文大写格式
		HSSFCellStyle cellStyle5 = workbook.createCellStyle();
		HSSFDataFormat format5 = workbook.createDataFormat();
		cellStyle5.setDataFormat(format5.getFormat("[DbNum2][$-804]0"));

		// 第六种：科学计数法格式
		HSSFCellStyle cellStyle6 = workbook.createCellStyle();
		cellStyle6.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00E+00"));

		HSSFRow hssfRow = null;
		HSSFCell cell = null;

		String color = "cbfdee";    //此处得到的color为16进制的字符串
	    	
		
		int r = Integer.parseInt((color.substring(0,2)),16);   //转为16进制
		int g = Integer.parseInt((color.substring(2,4)),16);
		int b = Integer.parseInt((color.substring(4,6)),16);
		
		
		//自定义cell颜色
		HSSFPalette palette = workbook.getCustomPalette();
		
		//这里的9是索引
		palette.setColorAtIndex((short)9, (byte) r, (byte) g, (byte) b);
		HSSFCellStyle style = workbook.createCellStyle();  
      //  style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 

        style.setFillForegroundColor((short)9);
		
		
		
		if (CollectionUtils.isNotEmpty(values))
		{
			for (int i = 0; i < values.size(); i++)
			{
				hssfRow = hssfSheet.createRow(i + 1);
				

				hssfRow.setHeightInPoints(20);
				
				ScheduleJobVo item = values.get(i);

				// 第六步，创建单元格，并设置值
				hssfRow.createCell(0).setCellValue(item.getJobGroup());
				hssfRow.createCell(1).setCellValue(item.getJobName());
				hssfRow.createCell(2).setCellValue(item.getJobTrigger());

				cell = hssfRow.createCell(3);
				cell.setCellValue(item.getNextFireTime());
				cell.setCellStyle(cellStyle);

				cell = hssfRow.createCell(4);
				cell.setCellValue(item.getPreviousFireTime());
				cell.setCellStyle(cellStyle);

				hssfRow.createCell(5).setCellValue(item.getStatus());
				hssfRow.createCell(6).setCellValue(item.getIsSync());
				hssfRow.createCell(7).setCellValue(item.getUrl());
				hssfRow.createCell(8).setCellValue(item.getDescription());
				hssfRow.createCell(9).setCellValue(item.getDescription());
			}
		}
	}
}