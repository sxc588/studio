package com.github.support.host.conttroller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.github.support.dto.DocDto;
import com.github.support.host.service.DocService;
import com.github.support.host.service.HostService;
import com.github.support.host.service.ImportExcelUtil;

@Controller
@RequestMapping("doc/")
public class DocController
{
	private static Logger logger = LoggerFactory.getLogger(DocController.class);

	@Autowired
	private DocService doc;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String regist(HttpServletRequest request, Model model)
	{
		// https://blog.csdn.net/ruthywei/article/details/74295612
		model.addAttribute("msg", "username");
		return "/doc/main";
	}

	 /**  
     * 描述：通过传统方式form表单提交方式导入excel文件  
     * @param request  
     * @throws Exception  
     */  
	@RequestMapping(value = "/upload", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView  upload(HttpServletRequest request,HttpServletResponse response
			// @RequestParam("description") String description,
			// @RequestParam("file") MultipartFile file
					)throws Exception
	{
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
	       System.out.println("通过传统方式form表单提交方式导入excel文件");  
	          
	        InputStream in =null;  
	        List<List<Object>> listob = null;  
	        MultipartFile file = multipartRequest.getFile("upfile");  
	        if(file.isEmpty()){  
	            throw new Exception("文件不存在！");  
	        }  
	        in = file.getInputStream();  
	        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());  
	        in.close();  
	          
	        List<InfoVo> tradeList = new ArrayList<InfoVo>();
	        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
	        for (int i = 0; i < listob.size(); i++) {  
	            List<Object> lo = listob.get(i);  
	            InfoVo vo = new InfoVo();  
	            vo.setCode(String.valueOf(lo.get(0)));  
	            vo.setName(String.valueOf(lo.get(1)));  
	            vo.setDate(String.valueOf(lo.get(2)));  
	            vo.setMoney(String.valueOf(lo.get(3)));  
	              
	            System.out.println("打印信息–>机构:"+vo.getCode()+"  名称："+vo.getName()+" 时间："+vo.getDate()+"资产："+vo.getMoney()); 
	            tradeList.add(vo);
	        }
	        
	        
	        System.err.println(tradeList.size());
	        
	        
	        ModelAndView  mv = new ModelAndView();
	        mv.setViewName("/doc/result");
	        mv.addObject("tradeList", tradeList);  
	        
	        return mv;  
	    }  
	      
	    /** 
	     * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件 
	     * @param request 
	     * @param response 
	     * @throws Exception 
	     */  
	    @ResponseBody  
	    @RequestMapping(value="ajaxUpload.do", method={RequestMethod.GET,RequestMethod.POST})  
	    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {  
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
	          
	        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");  
	          
	        InputStream in =null;  
	        List<List<Object>> listob = null;  
	        MultipartFile file = multipartRequest.getFile("upfile");  
	        if(file.isEmpty()){  
	            throw new Exception("文件不存在！");  
	        }  
	          
	        in = file.getInputStream();  
	        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());  
	          
	        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
	        for (int i = 0; i < listob.size(); i++) {  
	            List<Object> lo = listob.get(i);  
	            InfoVo vo = new InfoVo();  
	            vo.setCode(String.valueOf(lo.get(0)));  
	            vo.setName(String.valueOf(lo.get(1)));  
	            vo.setDate(String.valueOf(lo.get(2)));   
	            vo.setMoney(String.valueOf(lo.get(3)));  
	              
	            System.out.println("打印信息–>机构:"+vo.getCode()+"  名称："+vo.getName()+"   时间："+vo.getDate()+"   资产："+vo.getMoney());  
	        }  
	          
	        PrintWriter out = null;  
	        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
	        out = response.getWriter();  
	        out.print("文件导入成功！");  
	        out.flush();  
	        out.close();  
	    }
	

	@RequestMapping("/export")
	public @ResponseBody String export(HttpServletResponse response)
	{
		response.setContentType("application/binary;charset=UTF-8");
		try
		{
			ServletOutputStream out = response.getOutputStream();
			String fileName = new String(
					("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
			String[] titles = { "用户编号", "用户姓名", "用户密码", "用户年龄" };
			doc.export(titles, out);
			return "success";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "导出信息失败";
		}
	}
	
	
	@RequestMapping("/export2")
	public ModelAndView export2(HttpServletResponse response)
	{

				List<DocDto> tradeList = doc.getAll();
	     ModelAndView  mv = new ModelAndView();
	        mv.setViewName("/doc/result2");
	        mv.addObject("tradeList", tradeList);  
	        return mv;  
	}
}