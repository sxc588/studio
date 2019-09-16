package com.github.support.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.stereotype.Repository;

import com.github.support.vo.ScheduleJobVo;

@Repository
public class CommonQueryService {

	public static String ISOtoGBK(String s) {
		String str = "";
		try {
			if (s == null || s == "" || s.equals("")) {
				str = s;
			} else {
				str = new String(s.getBytes("ISO8859-1"), "GBK");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	private void DoTT(HSSFSheet hssfSheet, List<ScheduleJobVo> values) {
		HSSFRow hssfRow;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (values != null && !values.isEmpty()) {
			for (int i = 0; i < values.size(); i++) {
				hssfRow = hssfSheet.createRow(i + 1);
				ScheduleJobVo user = values.get(i);
				// 第六步，创建单元格，并设置值
				hssfRow.createCell(0).setCellValue(user.getJobName());
				hssfRow.createCell(1).setCellValue(ISOtoGBK(user.getAliasName()));
				hssfRow.createCell(2).setCellValue(user.getJobGroup());
				hssfRow.createCell(3).setCellValue(user.getJobTrigger());
				hssfRow.createCell(4).setCellValue(user.getStatus());
				hssfRow.createCell(5).setCellValue(user.getCronExpression());
				hssfRow.createCell(6).setCellValue(user.getIsSync());
				hssfRow.createCell(7).setCellValue(user.getUrl());
				hssfRow.createCell(8).setCellValue(user.getDescription());
			}
		}
	}

	public void export(String[] titles, List<ScheduleJobVo> values, ServletOutputStream out) {
		try {
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
			for (int i = 0; i < titles.length; i++) {
				hssfCell = hssfRow.createCell(i);// 列索引从0开始
				hssfCell.setCellValue(titles[i]);// 列名1
				hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
			}

			// 第五步，写入实体数据
			DoTT(hssfSheet, values);

			// 第七步，将文件输出到客户端浏览器
			try {
				workbook.write(out);
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}