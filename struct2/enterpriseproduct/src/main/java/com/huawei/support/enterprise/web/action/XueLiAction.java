package com.huawei.support.enterprise.web.action;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import com.huawei.support.enterprise.web.domain.Xueli;
import com.opensymphony.xwork2.Action;


/**
 * Action 满足三个要求：
 * 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 
 * 2. 数据fild , 提供 setter，getter 方法
 * 3. 无构造参数的构造器
 */
@Controller
public class XueLiAction implements Action
{
	public List<Xueli> getXueliList()
	{
		return xueliList;
	}

	public void setXueliList(List<Xueli> xueliList)
	{
		this.xueliList = xueliList;
	}

	private List<Xueli> xueliList;

	@Override
	public String execute()
	{
		xueliList = new ArrayList<Xueli>(); 
		
		xueliList.add(new Xueli("1","大专","基本"));
		xueliList.add(new Xueli("2","本科","刚刚好"));
		xueliList.add(new Xueli("3","硕士","高级人才"));
		xueliList.add(new Xueli("4","博士","高端人才"));
		xueliList.add(new Xueli("5","博士后","稀有人才"));
		xueliList.add(new Xueli("6","院士","稀有人才"));
		
		return SUCCESS;
	}
}
