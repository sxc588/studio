package org.fkjava.action.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.Environment;
import org.fkjava.action.BaseAcion;
import org.fkjava.domain.User;
import org.fkjava.service.AjaxObject;
import org.fkjava.service.AssociatedPersonnelService;
import org.fkjava.service.JSON;
import org.fkjava.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.github.cbb.utils.CookieUtil;
import com.github.cbb.utils.JSONUtil;
import com.github.support.work.mapper.VirtualMeshineInfoMapper;
import com.github.support.work.model.VirtualMeshineInfo;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.cache.SoftCacheStorage;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class UsersViewAction extends BaseAcion
{

	private static final long serialVersionUID = 2635886475870205495L;

	private static Logger log = LoggerFactory.getLogger(UsersViewAction.class);

	private List<User> users;

	private List<VirtualMeshineInfo> statgInfos;

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	@Autowired
	UserService userService;

	@Autowired
	VirtualMeshineInfoMapper virtualMeshineInfoMapper;

	List<EnvironmentInfo> envInfos;

	public List<EnvironmentInfo> getEnvInfos()
	{
		return this.envInfos;
	}

	public void setEnvInfos(List<EnvironmentInfo> envInfos)
	{
		this.envInfos = envInfos;
	}

	String stage;

	public String getStage()
	{
		return this.stage;
	}

	public void setStage(String stage)
	{
		this.stage = stage;
	}

	@Override
	public String execute()
	{

		stage = CookieUtil.getCookieStage(request);

		log.info(stage);
		users = userService.getAll();

		String json = JSONUtil.toJson(users);
		log.info(json);

		envInfos = EnvironmentServive.getEnvInfos("Alpha");

		VirtualMeshineInfo instance = new VirtualMeshineInfo();

		instance.setStage("Alpha");
		statgInfos = virtualMeshineInfoMapper.selectBySelection(instance);

		return SUCCESS;
	}

	private String urls;

	public String addone()
	{

		stage = CookieUtil.getCookieStage(request);
		log.info(stage);

		log.info(urls);

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

	public List<VirtualMeshineInfo> getStatgInfos()
	{
		return statgInfos;
	}

	public void setStatgInfos(List<VirtualMeshineInfo> statgInfos)
	{
		this.statgInfos = statgInfos;
	}

	public String getUrls()
	{
		return urls;
	}

	public void setUrls(String urls)
	{
		this.urls = urls;
	}
}
