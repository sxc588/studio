package com.github.cbb.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.github.cbb.http.client.HttpClientComm;
import com.github.cbb.http.client.HttpGetClient;

public class HttpClientTest {

    HttpClientComm http = new HttpGetClient();

    @Test
    public void testDoHead() throws UnsupportedEncodingException {
       HttpResponse resultString= http.doGet("https://support.huawei.com/carrierindex/pages/indexNew/img/5G-337-187.jpg",new HashMap<String,String>());
       resultString.getStatusLine().getStatusCode();
       System.out.println(resultString.getStatusLine().getStatusCode());
       System.out.println(JSON.toJSON(resultString.getAllHeaders()));
    }

}
