package com.github.support.controller.dl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController extends SimpleFormatter {
	private static Logger log = LoggerFactory.getLogger(UploadController.class);

	

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
	
	@RequestMapping("/uploads")
	    public ModelAndView fileUpload(HttpServletRequest request,@RequestParam MultipartFile[] upload) throws IOException {
	       
		 ModelAndView mv = new ModelAndView();
	        String path=request.getRealPath("/");
	        File file =new File(path);
	        if (!file.exists()){
	            file.mkdirs();
	        }
	        
	        
	        if (upload!=null&&upload.length>0){
	            for (int i=0;i<upload.length;i++){
	                String filename = upload[i].getOriginalFilename();
	                String uuid = UUID.randomUUID().toString().toUpperCase();
	                filename = uuid+"_"+filename;
	                upload[i].transferTo(new File(file,filename));
	                mv.addObject("info","上传成功!");
	                mv.setViewName("success");
	            }
	        }
	        return mv;
	    }

}
