package com.huawei.support.enterprise.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssociatedPersonnelService {

	public List<Map<String, Object>> getAssociatedPersonnelList(
			Map<String, Object> condition) {
		
		Map<String,Object> value = new HashMap<String,Object>();
		
		value.put("recipient_name", "value");
		value.put("organization_name", "value");
		value.put("recipient_dept_name", "value");
		value.put("post", "post");
		value.put("posttype", "post");
		value.put("direct_leadership", "00");
		value.put("id", 12345);
		
		List<Map<String, Object>> list  = new ArrayList<Map<String, Object>>();
		
		
		list.add(value);

		return list;
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

}
