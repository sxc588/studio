package org.fkjava.action;
import java.util.ArrayList;
import java.util.List;
import org.fkjava.domain.VirtualMechine;
import org.fkjava.domain.Xueli;
import org.springframework.stereotype.Controller;
import com.github.cbb.utils.json.JSONUtil;
import com.opensymphony.xwork2.Action;


/**
 * Action 满足三个要求：
 * 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 
 * 2. 数据filed , 提供 setter，getter 方法
 * 3. 无构造参数的构造器
 */
@Controller
public class XueLiAction implements Action
{

	private List<VirtualMechine> virtualMechines;

	@Override
	public String execute()
	{
		virtualMechines = new ArrayList<VirtualMechine>(); 
		
		virtualMechines.add(new VirtualMechine("ID生成器","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("ID生成器","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("ID生成器","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("ID生成器","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("ID生成器","大专","基本","ddddd","DDFF"));
		virtualMechines.add(new VirtualMechine("ID生成器","大专","基本","ddddd","DDFF"));
		String json = JSONUtil.toJson(virtualMechines);
		System.err.println(json);
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
