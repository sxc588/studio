package org.fkjava.action.uitags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.fkjava.action.JSONUtil;
import org.fkjava.domain.User;
import org.fkjava.service.AjaxObject;
import org.fkjava.service.AssociatedPersonnelService;
import org.fkjava.service.JSON;
import org.fkjava.service.UserService;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class CopyOfViewUsersAction extends ActionSupport
{

	private static final long serialVersionUID = 2635886475870205495L;

	private static Logger log = Logger.getLogger(CopyOfViewUsersAction.class);

	private List<User> users;

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	// @Autowired
	UserService userService = new UserService();;

	@Override
	public String execute()
	{
		users = userService.getAll();
		
		String json = JSONUtil.toJson(users);
		log.info(json);
		
	 System.err.println(json);
		return SUCCESS;
	}

	// @Autowired
	AssociatedPersonnelService associatedPersonnelService = new AssociatedPersonnelService();

	public String save()
	{

		log.error("save");

		try
		{// 保存基本信息附件信息

			associatedPersonnelService.save();
			// 关联人员列表
			Map<String, Object> condition = new HashMap<String, Object>();
			String user_id = "abcd";
			condition.put("personnel_id", user_id);
			List<Map<String, Object>> personnelList = associatedPersonnelService.getAssociatedPersonnelList(condition);
			return JSON.toJSON(personnelList); // 返回json格式数据
		}
		catch (Exception e)
		{
			// log.(e);
			return AjaxObject.newError("保存信息失败!").toString();
		}

	}
}
