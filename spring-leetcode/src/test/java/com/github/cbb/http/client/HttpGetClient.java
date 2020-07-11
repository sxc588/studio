package com.github.cbb.http.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.github.cbb.http.CodexCC;

public class HttpGetClient extends HttpClientComm {

    protected HttpGet httpget;
    
    protected HttpPost httppost;
    
    public void close() {
        if (httpget != null) {
            httpget.releaseConnection();
        }
        super.close();
    }

    /**
     * 
     * get请求传递的连接，请求头
     * 
     * @Data:上午11:15:10
     * @Package:testhttpclient.testhttpclient
     * @Return:Map<String,String>
     * @Auth:diao
     */
    @Override
    public HttpResponse doGet(String url, Map<String, String> headers) {

        HttpGet httpget = new HttpGet(url);

        httpget.setConfig(requestconfig);
        
        headers.forEach((a, b) -> {
            httpget.addHeader(a, b);
        });
        httpget.addHeader("cookie", cookies.toString().substring(1, cookies.toString().length() - 1));

        CloseableHttpResponse respose = null;

        try {
            
            respose = httpclient.execute(httpget);
            
        } catch (ClientProtocolException e) {
            CodexCC.log(e);
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return respose;
        // return getResData(respose, httpget);
    }

    @Override
    public HttpResponse doPost(String url, Map<String, String> headers, Map<String, String> params, String charset)
            throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HttpResponse doHead(String url, Map<String, String> headers, Map<String, String> params, String charset)
            throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        return null;
    }
}
