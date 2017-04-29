package com.github.cbb.utils.json;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import com.github.cbb.utils.HttpClientUtils;

public class HttpClientUtilsTest
{

	@Test
	public void testDoGet()
	{
		
		// 二级页面
		
		List<String> urls = new Vector<String>();
		urls.add("http://support.huawei.com/enterprise/Main!getStaticFootHtml.action?language=zh");
		urls.add("http://support.huawei.com/enterprise/js/share/ga.js?_=1491193750750");
		urls.add("http://support.huawei.com/enterprise/DocIndexAction!dealLoginStatus");
		urls.add("http://support.huawei.com/enterprise/DocIndexAction!getNewVideo?lang=zh&_=14911937507");
		urls.add("http://support.huawei.com/enterprise/NewDocIndexAction!getMyCustomizeResource.action?resourceType=1");
		urls.add("http://support.huawei.com/enterprise/Main!getUserProfiles.action?lang=zh");
		urls.add("http://support.huawei.com/enterprise/zh/doc/index.html");
		
		for (String url : urls)
		{
			HttpClientUtils.doGet(url);
		}
	}

	@Test
	public void testDoGet3()
	{
		
		// 三级页面
		List<String> urls = new Vector<String>();
		urls.add("http://support.huawei.com/enterprise/product-family!getProductList");

		urls.add("http://support.huawei.com/enterprise/product-family!getDoc");
		urls.add("http://support.huawei.com/enterprise/product-family!getDoc");
		urls.add("http://support.huawei.com/enterprise/product-family!getDoc");
		urls.add("http://support.huawei.com/enterprise/getVideoListActionByCondition!getVideoByCondition");
		urls.add("http://support.huawei.com/enterprise/Main!getUserProfiles.action");
		urls.add("http://support.huawei.com/enterprise/zh/doc/index.html");
		urls.add("http://support.huawei.com/enterprise/Main!getLoginRedirectUrl");
		urls.add("http://support.huawei.com/enterprise/getVideoListActionByCondition!getVideoByCondition");

		for (String url : urls)
		{
			HttpClientUtils.doGet(url);
		}
	}

	@Test
	public void getDoc()
	{

		List<String> pbiIds = Arrays.asList(new String[]
		{"21782167", "21782186", "21782165"});

		List<BasicNameValuePair> fromData = new ArrayList<BasicNameValuePair>();
		//fromData.add(new BasicNameValuePair("pbiIds", JSONUtil.toJson(pbiIds)));
		fromData.add(new BasicNameValuePair("limit", "5"));
		fromData.add(new BasicNameValuePair("limit", "1"));
		fromData.add(new BasicNameValuePair("requestType", "ajax.json"));
		
		List<Header> headers = new ArrayList<Header>();
		
		headers.add(new BasicHeader("Accept","application/json, text/javascript, */*; q=0.01"));
		headers.add(new BasicHeader("Accept-Encoding","gzip, deflate"));
		headers.add(new BasicHeader("Connectiont","98"));
		headers.add(new BasicHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8"));
		headers.add(new BasicHeader("Content-Type","application/json, text/javascript, */*; q=0.01"));
		headers.add(new BasicHeader("Cookie","_ha_id..82d20=64d1b3f09ce2162b.1491187270.1.1491235385.1491187306.; _ha_ses..82d20=cdc8cc5f4851ab1952bcfb9fd1d15170259c59d9; _dmpa_id=114758b2f1d8fe9b7d4d1c116603831483354167065.1483354112.1.1483354112.1483354112; __qca=P0-431242069-1487686254116; visitorId=3A6DC10FAFFE4BCF8464D817F5AF5188; per_last=1487686254122; s_fid=123543D2126BDDFA-04EC5DFC6FCC21C8; browsehappy=browsehappy; SupportV8SID=0000bFv5mM_FKNQbYTK9e707zI9:19h88ne04; supportlang=zh; supporteSID=0000-y6y56oDYENpY0Yrxyl_jUu:1b2v4kbpc; _gat_UA-34391348-2=1; hwa_track_id=bbaacc75fed3c8bf8c8c646c91cf20bafa80a78a; elocPBIID=0; __utma=135551347.777706598.1484753150.1491187257.1491235380.5; __utmb=135551347.3.10.1491235380; __utmc=135551347; __utmz=135551347.1484753285.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ga=GA1.2.777706598.1484753150; __havsid=SUPPORT.1483748875.762592358.1491235380; __hau=SUPPORT.1483748875.762592358; hwsso_uniportal=''; hwsso_login=''; enterpriselang=zh; supportelang=zh; lang=zh"));
		headers.add(new BasicHeader("Host","support.huawei.com"));
		headers.add(new BasicHeader("Origin","http://support.huawei.com"));
		headers.add(new BasicHeader("Referer","http://support.huawei.com/enterprise/zh/doc/category/switch-pid-1482605678974"));
		headers.add(new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"));
		headers.add(new BasicHeader("X-Requested-With","XMLHttpRequest"));

		HttpClientUtils.doPostForm("http://support.huawei.com/enterprise/product-family!getDoc", fromData,headers);
	}
	
}
