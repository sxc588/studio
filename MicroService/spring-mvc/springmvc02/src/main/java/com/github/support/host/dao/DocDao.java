package com.github.support.host.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.github.support.dto.DocDto;



@Repository
public class DocDao
{
	private static final Logger logger = Logger.getLogger(DocDao.class);

//	@Test
//	public void test1() {
// 
//		List<DocDto> aaa = getAll();
//	        
//	        System.err.println(aaa);
//	        
//	    //    http://support.huawei.com/enterpriseproduct/DocNewOfferingAction!getLableDocList.action
//	        
//	        
//	        
//	        
//	}
public List<DocDto> getAll()
	{
		String url0="http://support.huawei.com/enterprisecase/KnowledgebaseQueryAction!getKnowledgeInfoListByPbiIds?pageIndex=0&startDate=&endDate=&orderBy=publishTime+desc&resourceType=0&fTreeLevel1=&fTreeLevel2=&fTreeLevel3=&scene=-1&level=-1&title=&pageType=&itemsPerPage=20&pbiIds=%5B%22PBI2-21782167%22%2C%22PBI2-22318638%22%2C%22PBI2-21782165%22%2C%22PBI2-21782186%22%5D&level1=&ftreePath=&requestType=ajax.json";
		        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();  
	        params.add(new BasicNameValuePair("pageIndex", "0"));
	        params.add(new BasicNameValuePair("startDate", "")); 
	        params.add(new BasicNameValuePair("endDate", "")); 
	        params.add(new BasicNameValuePair("orderBy", "publishTimedesc")); 
	        params.add(new BasicNameValuePair("resourceType", "0")); 
	        params.add(new BasicNameValuePair("fTreeLevel1", "")); 
	        params.add(new BasicNameValuePair("fTreeLevel2", "")); 
	        params.add(new BasicNameValuePair("fTreeLevel3", "")); 
	        params.add(new BasicNameValuePair("scene", "-1")); 
	        params.add(new BasicNameValuePair("level", "-1")); 
	        params.add(new BasicNameValuePair("title", "-1")); 
	        params.add(new BasicNameValuePair("pageType", "")); 
	        params.add(new BasicNameValuePair("itemsPerPage", "20")); 
//	        params.add(new BasicNameValuePair("pbiIds", "[\"PBI2-21782167\",\"PBI2-22318638\",\"PBI2-21782165\",\"PBI2-21782186\"]")); 
	        params.add(new BasicNameValuePair("level1", ""));
	        params.add(new BasicNameValuePair("ftreePath", ""));
	        params.add(new BasicNameValuePair("requestType", "ajax.json"));
		      
	        String json =  getdata(url0, params);  
	        List<DocDto> aaa = JSON.parseArray(json, DocDto.class);
		return aaa;
	}
	
//	public static List<Object> doPost(String url, JSONObject json, String infoname, Class cl){  
//		  
//	       CloseableHttpClient httpclient = HttpClientBuilder.create().build();  
//	       HttpPost post = new HttpPost(url);  
//	       JSONObject response = null;  
//	       List<Object> list=new ArrayList<Object>();  
//	       try {  
//	           StringEntity s = new StringEntity(json.toString());  
//	           s.setContentEncoding("UTF-8");  
//	           s.setContentType("application/json");//发送json数据需要设置contentType  
//	           post.setEntity(s);  
//	           HttpResponse res = httpclient.execute(post);  
//	           if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) 
//	           {  
//	               String result = EntityUtils.toString(res.getEntity());// 返回json格式：  
//	           
////	               System.out.println(result);  
////	               response = JSONObject.parseObject(result);  
////	               List<JSONObject> info = (List) response.get(infoname);  
////	  
////	               for (JSONObject s1 : info) {  
////	                   Object netDownData = (Object) JSONObject.toJavaObject(s1, cl);  
////	                   list.add(netDownData);  
////	  
////	               }  
//	  
//	           }else{  
//	                   logger.error("拉取失败,错误编码为："+res.getStatusLine().getStatusCode());  
//	               }  
//	       } catch (Exception e) {  
//	           throw new RuntimeException(e);  
//	       }  
//	       return list;  
//	   }  

	public static String getdata(String url, List<NameValuePair> params)
	{
		String tag = "";
		HttpClient httpClient = HttpClientBuilder.create().build();  
		HttpPost post = new HttpPost(url);
		try
		{
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "utf-8");
			
			entity.setContentEncoding("UTF-8");  
			entity.setContentType("application/json");//发送json数据需要设置contentType  
			
			post.setEntity(entity);
		//	System.err.println(params);
			try
			{
				HttpResponse httpResponse = httpClient.execute(post);
				tag = "get string false";
				if (httpResponse.getStatusLine().getStatusCode() == 200)
				{
					HttpEntity entity2 = httpResponse.getEntity();
					tag = EntityUtils.toString(entity2);
//					 tag =
//					 Decodtool.decodeUnicode(URLDecoder.decode(EntityUtils.toString(entity2,
//					 "uft-8"), "utf-8"));
				}
			} catch (ClientProtocolException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return tag;

	}
}
