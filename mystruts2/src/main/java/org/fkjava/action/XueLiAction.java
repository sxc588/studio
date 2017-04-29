package org.fkjava.action;
import java.util.ArrayList;
import java.util.List;
import org.fkjava.domain.VirtualMechine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.github.cbb.utils.JSONUtil;


/**
 * Action 满足三个要求：
 * 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 
 * 2. 数据filed , 提供 setter，getter 方法
 * 3. 无构造参数的构造器
 */
@Controller
public class XueLiAction extends BaseAcion
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6826641360764274305L;
	
	private List<VirtualMechine> virtualMechines;
	
	
	private List<String> micService;

	public List<String> getMicService()
	{
		return this.micService;
	}

	@Autowired
	VirutalMechineService booksService = new VirutalMechineService();

	@Override
	public String execute()
	{
		virtualMechines = new ArrayList<VirtualMechine>(); 
		
		virtualMechines.add(new VirtualMechine("ID生成器","Alpha","基本","8080","8081"));
		virtualMechines.add(new VirtualMechine("ID生成器","Alpha","基本","8080","8081"));
		virtualMechines.add(new VirtualMechine("ID生成器","Beta","基本","8080","8081"));
		virtualMechines.add(new VirtualMechine("ID生成器","Beta","基本","8080","8081"));
		virtualMechines.add(new VirtualMechine("ID生成器","Gamma","基本","8080","8081"));
		virtualMechines.add(new VirtualMechine("ID生成器","Gamma","基本","8080","8081"));
		virtualMechines.add(new VirtualMechine("ID生成器","Product","基本","8080","8081"));
		virtualMechines.add(new VirtualMechine("ID生成器","Product","基本","8080","8081"));
		
		
		virtualMechines.add(new VirtualMechine("系统配置项","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("元数据","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("PBI","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("Html区域","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("I18n","大专","基本","ddddd","DDFF"));
		String json = JSONUtil.toJson(virtualMechines);
		System.err.println(json);
		
		micService = booksService.getServiceInfos("category");
		String json2 = JSONUtil.toJson(micService);
		System.err.println(json2);
		
		
		return SUCCESS;
	}

	public List<VirtualMechine> getVirtualMechines()
	{
		return virtualMechines;
	}

	public void setVirtualMechines(List<VirtualMechine> virtualMechines)
	{
		this.virtualMechines = virtualMechines;
	}
}
