package com.github.support.controller.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "setting/ztree")
public class ZeTreeController extends SimpleFormatter {

	public class zTreeNode {
		public zTreeNode(long id, long pId, String name, String t, boolean open) {
			super();
			this.id = id;
			this.pId = pId;
			this.name = name;
			this.t = t;
			this.open = open;
			
			this.isChecked = id %2 >0 ? true: false;
			
		}

		public boolean isChecked() {
			return isChecked;
		}

		public void setChecked(boolean isChecked) {
			this.isChecked = isChecked;
		}

		long id;// : 1,
		long pId;// : 0,
		String name;// : "父节点1 - 展开",
		String t;// : '物资类别',
		boolean open;// : true
		boolean isChecked;// : true

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getpId() {
			return pId;
		}

		public void setpId(long pId) {
			this.pId = pId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getT() {
			return t;
		}

		public void setT(String t) {
			this.t = t;
		}

		public boolean isOpen() {
			return open;
		}

		public void setOpen(boolean open) {
			this.open = open;
		}
	}

	private static Logger log = LoggerFactory.getLogger(ZeTreeController.class);

	private HttpSession session;

	@RequestMapping(value = "/tree")
	@ResponseBody
    public List<zTreeNode> getCategoryTree() {
    	log.info("tree");
        List<zTreeNode> rooTreeNodes = new ArrayList<ZeTreeController.zTreeNode>();
        
        // id,pId,name,t,open
        rooTreeNodes.add(new zTreeNode(1,0,"应用管理","产品", true));
        rooTreeNodes.add(new zTreeNode(11,1,"资源管理","OS", true));
        rooTreeNodes.add(new zTreeNode(111,11,"应用管理","Cluster", true));       
        rooTreeNodes.add(new zTreeNode(111,11,"集群管理","Cluster", true)); 
        rooTreeNodes.add(new zTreeNode(111,11,"监控","Cluster", true));
        rooTreeNodes.add(new zTreeNode(111,11,"SLA","Cluster", true));
        rooTreeNodes.add(new zTreeNode(112,12,"中间件","Cluster", true));
        rooTreeNodes.add(new zTreeNode(111,11,"监控","Cluster", true));
        rooTreeNodes.add(new zTreeNode(111,11,"主机","Cluster", true));
        rooTreeNodes.add(new zTreeNode(111,11,"监控","Cluster", true));
        
        rooTreeNodes.add(new zTreeNode(12,1,"SupportE","产品", true));       
        rooTreeNodes.add(new zTreeNode(121,12,"父节点121 - 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(124,12,"父节点124 - 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(13,1,"主机- 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(2,0,"父节点2 - 展开","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(21,2,"父节点11 - 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(122,21,"父节点122 - 折叠","物资类别", true));  
               
        return rooTreeNodes;
    }
    
    
    @RequestMapping(value = "/tree2")
	@ResponseBody
    public List<zTreeNode> getCategoryTree2() {
    	log.info("tree");
        List<zTreeNode> rooTreeNodes = new ArrayList<ZeTreeController.zTreeNode>();
        
        // id,pId,name,t,open
        rooTreeNodes.add(new zTreeNode(1,0,"Support","产品", true));
        rooTreeNodes.add(new zTreeNode(11,1,"虚拟机 ","OS", true));
        rooTreeNodes.add(new zTreeNode(111,11,"Mysql","Cluster", true));       
        rooTreeNodes.add(new zTreeNode(112,12,"Oracle","Cluster", true)); 
        rooTreeNodes.add(new zTreeNode(111,11,"Redis","Cluster", true));       
        rooTreeNodes.add(new zTreeNode(112,12,"Redis","Cluster", true)); 
        rooTreeNodes.add(new zTreeNode(112,12,"Consul","Cluster", true)); 
        rooTreeNodes.add(new zTreeNode(112,12,"Dubbox","物资类别", true)); 
        
        rooTreeNodes.add(new zTreeNode(12,1,"SupportE","产品", true));       
        rooTreeNodes.add(new zTreeNode(121,12,"父节点121 - 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(124,12,"父节点124 - 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(13,1,"主机- 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(2,0,"父节点2 - 展开","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(21,2,"父节点11 - 折叠","物资类别", true));  
        rooTreeNodes.add(new zTreeNode(122,21,"父节点122 - 折叠","物资类别", true));  
               
        return rooTreeNodes;
    }

}
