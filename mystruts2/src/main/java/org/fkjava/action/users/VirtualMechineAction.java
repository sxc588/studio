package org.fkjava.action.users;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.Environment;
import org.apache.wss4j.binding.wsu10.AbstractAttributedDateTime;
import org.fkjava.domain.User;
import org.fkjava.domain.VirtualMechine;
import org.fkjava.service.AjaxObject;
import org.fkjava.service.AssociatedPersonnelService;
import org.fkjava.service.JSON;
import org.fkjava.service.UserService;
import org.fkjava.service.VMUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.github.cbb.action.BaseAcion;
import com.github.cbb.json.JSONUtil;
import com.github.cbb.web.CookieUtil;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.cache.SoftCacheStorage;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class VirtualMechineAction extends BaseAcion
{

	private static final long serialVersionUID = 2635886475870205495L;

	private static Logger log = LoggerFactory.getLogger(VirtualMechineAction.class);

	@Autowired
	VMUrlService uvmurlervice;

	@Autowired
	VirtualMeshineInfoMapper virtualMeshineInfoMapper;

	List<EnvironmentInfo> envInfos;
	
	
	private List<VirtualMechine> vminfos;

	public List<VirtualMechine> getVminfos()
	{
		return this.vminfos;
	}

	public void setVminfos(List<VirtualMechine> vminfos)
	{
		this.vminfos = vminfos;
	}

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
		vminfos = uvmurlervice.getAll();

		log.info(JSONUtil.toJson(vminfos));

		envInfos = EnvironmentServive.getEnvInfos("Alpha");

		return SUCCESS;
	}

	private String urls;

	public void addone() throws IOException
	{
		stage = CookieUtil.getCookieStage(request);
		log.info(stage);

		log.info(urls);
		if (StringUtils.isNotBlank(urls))
		{
			String[] strArray = urls.split(",");
			
			uvmurlervice.addUrls(stage, strArray);
		}
		response.sendRedirect("/struts2/Alpha");
		// return SUCCESS;
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


	public String getUrls()
	{
		return urls;
	}

	public void setUrls(String urls)
	{
		this.urls = urls;
	}
}
