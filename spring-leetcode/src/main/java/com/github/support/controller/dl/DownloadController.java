package com.github.support.controller.dl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.logging.SimpleFormatter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/download")
public class DownloadController extends SimpleFormatter {
	private static Logger log = LoggerFactory.getLogger(DownloadController.class);

	
	/**
	 *  
	 * @param 基于ResponseEntity实现
	 * @return
	 */
	@RequestMapping(value = "/httpdl", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(HttpServletRequest request) {
		File file = new File("d://QQ20140923091618.jpg");
		byte[] body = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			body = new byte[is.available()];
			is.read(body);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attchement;filename=" + file.getName());
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
		return entity;
	}

	
	/*
	 * Java通用下载实现
	 */
	@RequestMapping(value = "/dl1", method = RequestMethod.GET)
	public void downloadv1(@RequestParam(value="fileName",defaultValue="QQ20140923091618.jpg")String fileName,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		log.info("enter-->downloadv1");
		download(fileName,request,response);
				
		// 存储记录
	}
	
	/*
	 * Java通用下载实现
	 */
	@RequestMapping(value = "/dl2/{fileName}", method = RequestMethod.GET)
	public void downloadv2(@PathVariable(value = "fileName")String fileName,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("enter-->downloadv2");
		download(fileName+".jpg",request,response);
				
		// 存储记录
	}
	
	/*
	 * Java通用下载实现
	 */
	@RequestMapping(value = "/dl3", method = RequestMethod.GET)
	public void downloadv3(String fileName,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		download(fileName,request,response);
				
		// 存储记录
	}

	public DownloadRecord download(String fileName,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String filePath= "d://" + fileName ;
		
		// 声明本次下载状态的记录对象
		DownloadRecord downloadRecord = new DownloadRecord(fileName, filePath, request);
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		// 用于记录以完成的下载的数据量，单位是byte
		long downloadedLength = 0l;
		try {
			// 打开本地文件流
			InputStream inputStream = new FileInputStream(filePath);
			// 激活下载操作
			OutputStream os = response.getOutputStream();

			// 循环写入输出流
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
				downloadedLength += b.length;
			}

			// 这里主要关闭。
			os.close();
			inputStream.close();
		} catch (Exception e) {
			downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
			throw e;
		}
		downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
		downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
		downloadRecord.setLength(downloadedLength);
		// 存储记录
		return downloadRecord;
	}

	
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest req)
			throws IllegalStateException, IOException {

		// 判断文件是否为空，空则返回失败页面
		if (file.isEmpty()) {
			return "failed";
		}
		// 获取文件存储路径（绝对路径）
		String path = "c://aaaa";
		// 获取原文件名
		String fileName = file.getOriginalFilename();
		// 创建文件实例
		File filePath = new File(path, fileName);
		// 如果文件目录不存在，创建目录
		if (!filePath.getParentFile().exists()) {
			filePath.getParentFile().mkdirs();
			System.out.println("创建目录" + filePath);
		}
		// 写入文件
		file.transferTo(filePath);
		return "success";
	}  
	
	
	
	@RequestMapping(value = "/img", method = RequestMethod.GET)
	public void imvage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		VerifyCode code = new VerifyCode();
		BufferedImage image = code.createImage();
		ImageIO.write(image,"jpg",response.getOutputStream());			
		// 存储记录
	}		
}
