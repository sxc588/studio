package com.github.support.host.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.github.support.dto.DocDto;
import com.github.support.host.dao.DocDao;

@Repository
public class DocService
{
	@Autowired
	private DocDao hostDao;

	public void export(String[] titles, ServletOutputStream out)
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
			DoTT(hssfSheet);

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
	public static String getEncoding(String str) {    
        String encode = "GB2312";    
       try {    
           if (str.equals(new String(str.getBytes(encode), encode))) {    
                String s = encode;    
               return s;    
            }    
        } catch (Exception exception) {    
        }    
        encode = "ISO-8859-1";    
       try {    
           if (str.equals(new String(str.getBytes(encode), encode))) {    
                String s1 = encode;    
               return s1;    
            }    
        } catch (Exception exception1) {    
        }    
        encode = "UTF-8";    
       try {    
           if (str.equals(new String(str.getBytes(encode), encode))) {    
                String s2 = encode;    
               return s2;    
            }    
        } catch (Exception exception2) {    
        }    
        encode = "GBK";    
       try {    
           if (str.equals(new String(str.getBytes(encode), encode))) {    
                String s3 = encode;    
               return s3;    
            }    
        } catch (Exception exception3) {    
        }    
       return "";    
    }    
	public static String ISOtoGBK(String s) {
		  String str = "";
		  try {
		   if (s == null || s == "" || s.equals("")) {
		    str = s;
		   } else {
		    str = new String(s.getBytes("ISO-8859-1"),"UTF-8");    
		   }   
		  } catch (UnsupportedEncodingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } 
		  return  str;
		 }



	private void DoTT(HSSFSheet hssfSheet)
	{
		HSSFRow hssfRow;
		List<DocDto> users = getAll();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		if (!CollectionUtils.isEmpty(users))
		{
			for (int i = 0; i < users.size(); i++)
			{
				hssfRow = hssfSheet.createRow(i + 1);
				DocDto user = users.get(i);

				// 第六步，创建单元格，并设置值
				hssfRow.createCell(0).setCellValue(user.getContentId());
				hssfRow.createCell(1).setCellValue(ISOtoGBK(user.getName()));
				hssfRow.createCell(2).setCellValue(user.getName_url());
				hssfRow.createCell(3).setCellValue(user.getCreateBy());
			}
		}
	}
	public List<DocDto> getAll()
	{
		List<DocDto> users = hostDao.getAll();
		return users;
	}
}