package com.github.support.controller.entitle;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.support.vo.ScheduleJobVo;
import com.github.support.vo.UserVo;

/**
 * author : benjamin createTime : 2017.06.06 description : 用户管理控制器 version : 1.0
 */
@Controller
@RequestMapping(value = "/entitle/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	// @Autowired
	// private HostService hostService;

	@RequestMapping(value = "chart", method = RequestMethod.GET)
	public String chart(HttpServletRequest request, Model model) {
		// https://blog.csdn.net/ruthywei/article/details/74295612
		model.addAttribute("msg", "username");
		return "cmdb/host/chart";
	}

	@RequestMapping("/doget")
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String page = "1";
		String rows = "1";
		page = request.getParameter("page");
		rows = request.getParameter("rows");
		if (page == null) {
			page = "1";
		}
		if (rows == null) {
			rows = "2";
		}
		System.out.println("page: " + page + " rows: " + rows);
		int totalRecord = 12; // 总记录数(应根据数据库取得，在此只是模拟)
		int totalPage = totalRecord % Integer.parseInt(rows) == 0 ? totalRecord / Integer.parseInt(rows)
				: totalRecord / Integer.parseInt(rows) + 1; // 计算总页数
		try {
			int index = (Integer.parseInt(page) - 1) * Integer.parseInt(rows); // 开始记录数0
			int pageSize = Integer.parseInt(rows);// 2
			// 以下模拟构造JSON数据对象 ,该对象是jqgrid的默认返回对象
			String json = "{total: " + totalPage + ", page: " + page + ", records: " + totalRecord + ", rows: [";
			for (int i = index; i < pageSize + index && i < totalRecord; i++) {
				json += "{'id':'" + i + "','invdate':'" + i + "','name':'" + i + "','amount':'" + i + "','tax':'" + i
						+ "','total':'" + i + "','note':'" + i + "'}";
				if (i != pageSize + index - 1 && i != totalRecord - 1) {
					json += ",";
				}
			}
			json += "]}";
			System.out.println(json);
			response.getWriter().write(json); // 将JSON数据返回页面
		} catch (Exception ex) {
		}
	}

	@RequestMapping("/export")
	public @ResponseBody String export(HttpServletResponse response) {
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream out = response.getOutputStream();
			String fileName = new String(
					("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
			String[] titles = { "用户编号", "用户姓名", "用户密码", "用户年龄" };
			// hostService.export(titles, out);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "导出信息失败";
		}
	}

	/**
	 * 任务列表页
	 *
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public Map<String, Object> listScheduleJob2(ScheduleJobVo scheduleJobVo, ModelMap modelMap) {

		System.err.println("DDDDDDDDDDDDDDDDDDD");

		Map<String, Object> valus = new HashMap<String, Object>();

		valus.put("total", "3");
		valus.put("page", "1");
		valus.put("records", "15");

		// List<Map<String,Object>> scheduleJobVoList = new
		// ArrayList<Map<String,Object>>();
		//
		// Map<String, Object> dt = new HashMap<String, Object>();
		// dt.put("id", "1");
		// dt.put("cell", new UserVo("Otto Clay---", 25, 1, "Ap #897-1459 Quam
		// Avenue", false));
		//
		// scheduleJobVoList.add(dt);

		List<UserVo> scheduleJobVoList = new ArrayList<UserVo>();

		scheduleJobVoList.add(new UserVo("Otto Clay---", 25, 1, "Ap #897-1459 Quam Avenue", false));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Ramona Benton", 32, 3, "Ap #614-689 Vehicula Street", false));
		scheduleJobVoList.add(new UserVo("Otto Clay---", 25, 1, "Ap #897-1459 Quam Avenue", false));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Ramona Benton", 32, 3, "Ap #614-689 Vehicula Street", false));

		scheduleJobVoList.add(new UserVo("Otto Clay---", 25, 1, "Ap #897-1459 Quam Avenue", false));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Ramona Benton", 32, 3, "Ap #614-689 Vehicula Street", false));

		scheduleJobVoList.add(new UserVo("Otto Clay---", 25, 1, "Ap #897-1459 Quam Avenue", false));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Ramona Benton", 32, 3, "Ap #614-689 Vehicula Street", false));

		scheduleJobVoList.add(new UserVo("Otto Clay---", 25, 1, "Ap #897-1459 Quam Avenue", false));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Lacey Hess", 29, 3, "Ap #365-8835 Integer St.", false));
		scheduleJobVoList.add(new UserVo("Timothy Henson", 56, 1, "911-5143 Luctus Ave", true));
		scheduleJobVoList.add(new UserVo("Connor Johnston", 45, 2, "Ap #370-4647 Dis Av.", true));
		scheduleJobVoList.add(new UserVo("Ramona Benton", 32, 3, "Ap #614-689 Vehicula Street", false));

		valus.put("rows", scheduleJobVoList);
		return valus;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String page(HttpServletRequest request, Model model) {
		// https://blog.csdn.net/ruthywei/article/details/74295612

		String page = request.getParameter("page");

		if (StringUtils.isBlank(page)) {
			page = "chart";
		}

		model.addAttribute("msg", "username");
		return "cmdb/host/" + page;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String regist(HttpServletRequest request, Model model) {
		// https://blog.csdn.net/ruthywei/article/details/74295612
		model.addAttribute("msg", "username");
		return "cmdb/user/listView";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request,
			// @RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception {

		// System.out.println(description);
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getContextPath() + "/images/";
			// 上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + filename));
			return "success";
		} else {
			return "error";
		}

	}
}
