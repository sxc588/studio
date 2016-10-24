package com.bolo.examples.base.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.bolo.examples.base.Listener.CustomerProgressListener;
import com.bolo.examples.base.entity.User;
import com.bolo.examples.base.service.UserService;
import com.bolo.examples.base.utils.BaseTools;
import com.bolo.examples.base.utils.WebConstants;
import com.bolo.examples.base.vo.UserRegist;

/**
 * 人员管理
 * 
 * @author 菠萝大象
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, User user) {
		model.addAttribute("list", userServiceImpl.queryResult(user));
		model.addAttribute("entity", user);
		return "base/user_list";
	}

	@ResponseBody
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public String validateName(@RequestParam String name) {

		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="page/userAvatar", method = RequestMethod.GET)
	public ModelAndView redirectUser(HttpSession session){
		//String userId = BaseTools.getWebUserConstants(session).getUserId();//获取session里登入用户的id
		String userId = "DA0DF8DFC18BB561E040007F01003AAE";
		UserRegist userRegist = userServiceImpl.selectByUserId(userId);
		
		//拼装为jsp识别的图片URL

		String fullImgUrl = WebConstants.SYSTEM_UPLOADPATH+"\\" + userId + "\\" + userRegist.getMemberImg();
		fullImgUrl = fullImgUrl.replace("\\","/");
		String[] fullImgUrlArray = fullImgUrl.split(",");//对src进行切割,图片有其他参数
		String memberImg = fullImgUrlArray[0];
		String memberImgWidth = fullImgUrlArray[1];
		String memberImgHeight = fullImgUrlArray[2];
		String memberImgMarginLeft = fullImgUrlArray[3];
		String memberImgMarginTop = fullImgUrlArray[4];
		userRegist.setMemberImg(memberImg);
		userRegist.setMemberImgWidth(memberImgWidth);
		userRegist.setMemberImgHeight(memberImgHeight);
		userRegist.setMemberImgMarginLeft(memberImgMarginLeft);
		userRegist.setMemberImgMarginTop(memberImgMarginTop);
				
				
		//拼接返回对象
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("webConstants", BaseTools.getWebUserConstants(session));
		map.put("UserRegist", userRegist);
				
		return new ModelAndView("userAvatar",map);
	}
	
	
	/**
	 * 跳转到修改用户头像页面
	 */
	@RequestMapping(value = "changeUserAvatar", method = RequestMethod.GET)
	public ModelAndView changeUserAvatar(HttpSession session){
		//String userId = BaseTools.getWebUserConstants(session).getUserId();//获取session里登入用户的id
		String userId = "DA0DF8DFC18BB561E040007F01003AAE";
		UserRegist userRegist = userServiceImpl.selectByUserId(userId);
		//拼装为jsp识别的图片URL
		String fullImgUrl = WebConstants.SYSTEM_UPLOADPATH+"\\" + userId + "\\" + userRegist.getMemberImg();
		fullImgUrl = fullImgUrl.replace("\\","/");
		String[] fullImgUrlArray = fullImgUrl.split(",");//对src进行切割,图片有其他参数
		String memberImg = fullImgUrlArray[0];
		String memberImgWidth = fullImgUrlArray[1];
		String memberImgHeight = fullImgUrlArray[2];
		String memberImgMarginLeft = fullImgUrlArray[3];
		String memberImgMarginTop = fullImgUrlArray[4];
		userRegist.setMemberImg(memberImg);
		userRegist.setMemberImgWidth(memberImgWidth);
		userRegist.setMemberImgHeight(memberImgHeight);
		userRegist.setMemberImgMarginLeft(memberImgMarginLeft);
		userRegist.setMemberImgMarginTop(memberImgMarginTop);
		
		
		//拼接返回对象
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("webConstants", BaseTools.getWebUserConstants(session));
		map.put("UserRegist", userRegist);
		
		return new ModelAndView("userAvatar",map);
	}
	
	
	
	/**
	 * 跳转到修改用户头像页面,保存用户上传图片
	 *  
	 */
	@RequestMapping(value = "changeUserAvatar", method = RequestMethod.POST) 
	public ModelAndView saveUserAvatar(@ModelAttribute("UserRegist") UserRegist userRegist, 
			HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		LOG.info("-----------------修改用户头像页面 开始-----------------");
		String userId = "DA0DF8DFC18BB561E040007F01003AAE";
		//String userId = BaseTools.getWebUserConstants(session).getUserId();//获取session里登入用户的id
		String uploadPath = WebConstants.SYSTEM_UPLOADPATH;
		response.setContentType("text/html;charset=UTF-8");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			LOG.info("-----------------UnsupportedEncodingException错误-----------------");
			e1.printStackTrace();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// factory.setSizeThreshold(4096); //设置将文件存放在内存还是临时文件夹的临界值
		// factory.setRepository(tempPath); //设置当文件的大小超出sizeThrehold临界值时,存放的路径 默认“tomcat/temp/”

		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setProgressListener(new CustomerProgressListener(request));//上传进度监听器绑定到ServletFileUpload
		//upload.setSizeMax(2 * 1024 * 1024); //设置请求消息实体内容（所有上传的数据）的最大尺寸限制
		//upload.setFileSizeMax(100000); //设置单个上传文件的最大尺寸
		upload.setHeaderEncoding("utf-8");//上传文件的那个路径编码
		List<FileItem> fileItems = null;
		String userPic = "";
		String userPicAndParameter = "";
		try {
			fileItems = upload.parseRequest(request);
			Iterator<FileItem> iter = fileItems.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					String name = item.getName();
					long size = item.getSize();
					if ((name == null || name.equals("")) && size == 0){
						//忽略其他不是文件域的所有表单信息
						continue;
					}
					//根据用户ID判断目标目录是否存在,如果不存在需要创建
					//创建文件夹开始
					//每次清空,再建立文件夹
					BaseTools.deleteAllFiles(uploadPath,userId,new File(""));
			        File fileDir = new File(uploadPath + "\\"+userId);
			        fileDir.mkdirs();
			        /*if(!fileDir.exists()){  
			        	fileDir.mkdirs();  
			        }*/
					//创建文件夹完毕
					
					//文件写入目标目录
					File file = new File(uploadPath + "/" + userId + "/" +new File(name).getName());
					item.write(file);//读取的文件,写入
					
					//物理存储结束,写入数据库表保存用户的图片ID路径
					userPic = new File(name).getName();
					userPicAndParameter = userPic.concat(",100px,100px,0px,0px");
					userRegist.setMemberId(userId);
					userRegist.setMemberImg(userPicAndParameter);
					//update imgSrc
					int count = userServiceImpl.updateUserPic(userRegist);
					
				}
			}
			response.getWriter().flush();//清空缓存
			//response.getWriter().close();//这个不能加
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		//拼装为jsp识别的图片URL
		String fullImgUrl = WebConstants.SYSTEM_UPLOADPATH+"\\" + userRegist.getMemberId() + "\\" + userPic;
		fullImgUrl = fullImgUrl.replace("\\","/");
		userRegist.setMemberImg(fullImgUrl);//图片变回来带路径
		userRegist.setMemberImgWidth("100px");//首次上传默认
		userRegist.setMemberImgHeight("100px");//首次上传默认
		userRegist.setMemberImgMarginLeft("0px");//首次上传默认
		userRegist.setMemberImgMarginTop("0px");//首次上传默认
		

		
		LOG.info("-----------------修改用户头像页面 结束-----------------");
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("webConstants", BaseTools.getWebUserConstants(session));
		map.put("UserRegist", userRegist);
		return new ModelAndView("userAvatar",map);
	}
	
	
	/**
	 * 获取上传文件的进度信息,结果保存在session里面(Ajax)
	 */
	@RequestMapping(value="changeUserAvatar/progressBar" , method = RequestMethod.POST)
	@ResponseBody
	public String getUploadProcess(@RequestParam String time,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
        //PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();  
        Double percentage = 0.0;
        if(session.getAttribute("percentage") != null){
            percentage = (Double)session.getAttribute("percentage");  
            double retVal = Math.floor(percentage*100);
            if(retVal == 100.0D){
                session.removeAttribute("percentage");  
            }
            return "{\"retVal\":\""+retVal+"\"}";
        }else{
        	return "{\"retVal\":\"100.0D\"}";
        }
    }
	
	
	/**
	 * 跳转到修改用户头像页面,保存用户上传图片
	 */
	@RequestMapping(value = "changeUserAvatar/cutUserAvatar", method = RequestMethod.POST) 
	public ModelAndView saveCutUserAvatar(@ModelAttribute("UserRegist") UserRegist userRegist, 
			HttpSession session) {
		LOG.info("-----------------保存用户裁剪的头像参数 开始-----------------");
		String userId = "DA0DF8DFC18BB561E040007F01003AAE";
		//String userId = BaseTools.getWebUserConstants(session).getUserId();//获取session里登入用户的id
		userRegist.setMemberId(userId);
		
		String memberImg = StringUtils.isBlank(userRegist.getMemberImg()) ? "" : userRegist.getMemberImg().trim();//图像文件名
		String memberImgWidth = StringUtils.isBlank(userRegist.getMemberImgWidth()) ? "0" : userRegist.getMemberImgWidth().trim();//图像宽
		String memberImgHeight = StringUtils.isBlank(userRegist.getMemberImgHeight()) ? "0" : userRegist.getMemberImgHeight().trim();//图像高
		String memberImgMarginLeft = StringUtils.isBlank(userRegist.getMemberImgMarginLeft()) ? "0" : userRegist.getMemberImgMarginLeft().trim();//图像文件名
		String memberImgMarginTop = StringUtils.isBlank(userRegist.getMemberImgMarginTop()) ? "0" : userRegist.getMemberImgMarginTop().trim();//图像文件名
		
		String finalMemberImg = memberImg.concat(",").concat(memberImgWidth)
		         .concat(",").concat(memberImgHeight)
		         .concat(",").concat(memberImgMarginLeft)
		         .concat(",").concat(memberImgMarginTop).toString();
		userRegist.setMemberImg(finalMemberImg);//改变图片名,有名字+4个参数+逗号隔开
		int count = userServiceImpl.updateUserPic(userRegist);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("webConstants", BaseTools.getWebUserConstants(session));
		String fullImgUrl = WebConstants.SYSTEM_UPLOADPATH+"\\" + userId + "\\" + memberImg;
		fullImgUrl = fullImgUrl.replace("\\","/");
		userRegist.setMemberImg(fullImgUrl);//图片变回来带路径
		map.put("UserRegist", userRegist);
		LOG.info("-----------------保存用户裁剪的头像参数 结束-----------------");
		return new ModelAndView("userAvatar",map);
	}
	
	
	
	/**
	 *  JSP显示本地图片,流形式GET
	 */
	@RequestMapping(value = "changeUserAvatar/displayImage", method = RequestMethod.GET)
	public void getTheImageStream2(HttpServletRequest request, HttpServletResponse response) {
		LOG.info("-----------------显示用户头像2 开始-----------------");
        response.setContentType("image/*; charset=UTF-8");
		String filePath = request.getParameter("UserRegist");//这里本来是应该取登入后request传递过去的值,这里直接赋值
		//filePath = "D:/temp/wxcs/DA0DF8DFC18BB561E040007F01003AAE/Hydrangeas.jpg";
		
		//处理对默认头像的显示方式
		int imgIndex = filePath.lastIndexOf("/");
		String imgName = filePath.substring(imgIndex+1);
		if(imgName.equals(WebConstants.DEFAULT_AVATAR_IMG)){//默认头像
			//修改图片地址为特殊的默认头像
			filePath = WebConstants.SYSTEM_UPLOADPATH + "/" +WebConstants.DEFAULT_AVATAR_IMG;
			filePath = filePath.replace("\\", "/");
		}else{
			//正常打开图片地址
		}
		
		
		FileInputStream fileIn;
		OutputStream out;
		try {
			fileIn = new FileInputStream(filePath);// 以byte流的方式打开文件
			int i = fileIn.available();//得到文件大小   
	        byte[] data = new byte[i];   
	        fileIn.read(data);  //读数据放入 byte[]
	        out = response.getOutputStream(); //得到向客户端输出二进制数据的对象   
	        out.write(data);  //输出数据   
	        out.flush();
	        out.close();   
	        fileIn.close();
		} catch (IOException e) {
			LOG.info("-----------------异常抛出IOException-----------------");
			e.printStackTrace();
		}
		LOG.info("-----------------显示用户头像2 结束-----------------");
	}
}