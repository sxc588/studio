package com.github.support.controller.dl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.omg.CORBA.portable.InputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public class dd {

	
	/**
	 * 基于ResponseEntity实现
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/testHttpMessageDown")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
	    File file = new File("E://123.jpg");
	    byte[] body = null;
	    InputStream is = new FileInputStream(file);
	    body = new byte[is.available()];
	    is.read(body);
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attchement;filename=" + file.getName());
	    HttpStatus statusCode = HttpStatus.OK;
	    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
	    return entity;
	}
	
	/**
	 * Java通用下载实现
下载过程的实现，在java中调用reponse.getOutputStream()方法会自动激活下载操作
	 * @param fileName
	 * @param filePath
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void download(String fileName, String filePath,
			HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			    //声明本次下载状态的记录对象
			    DownloadRecord downloadRecord = new DownloadRecord(fileName, filePath, request);
			    //设置响应头和客户端保存文件名
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("multipart/form-data");
			    response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			    //用于记录以完成的下载的数据量，单位是byte
			    long downloadedLength = 0l;
			    try {
			        //打开本地文件流
			        InputStream inputStream = new FileInputStream(filePath);
			        //激活下载操作
			        OutputStream os = response.getOutputStream();

			        //循环写入输出流
			        byte[] b = new byte[2048];
			        int length;
			        while ((length = inputStream.read(b)) > 0) {
			            os.write(b, 0, length);
			            downloadedLength += b.length;
			        }

			        // 这里主要关闭。
			        os.close();
			        inputStream.close();
			    } catch (Exception e){
			        downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
			        throw e;
			    }
			    downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
			    downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
			    downloadRecord.setLength(downloadedLength);
			    //存储记录
			}
}
