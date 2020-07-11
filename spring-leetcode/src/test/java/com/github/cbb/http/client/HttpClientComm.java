package com.github.cbb.http.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public abstract class HttpClientComm {

    /**
     * 客户端总成
     */
    protected CloseableHttpClient httpclient;
    /**
     * cookie信息
     */
    protected Set<String> cookies;

    /**
     * 代理
     */
    protected HttpHost proxy;
    /**
     * 设置默认延迟时间
     */
    protected RequestConfig requestconfig;
    /**
     * 返回存储数据map
     */
    protected Map<String, String> resultmap;

    /**
     * 响应状态
     */
    public final String HTTPSTATUS = "status";
    /**
     * 返回数据结果
     */
    public final String HTTPRESULT = "httpresult";

    /**
     * 初始化客户端
     */
    public HttpClientComm() {
        httpclient = HttpClients.createDefault();
        requestconfig = RequestConfig.custom().setConnectionRequestTimeout(10 * 1000).setSocketTimeout(10 * 1000)
                .build();
        cookies = new HashSet<String>(16);
    }

    /**
     * 初始化请求，设置请求时间
     * 
     * @param millistimeout
     */
    public HttpClientComm(int millistimeout) {
        httpclient = HttpClients.createDefault();
        requestconfig = RequestConfig.custom().setConnectionRequestTimeout(10 * 1000).setSocketTimeout(10 * 1000)
                .build();
        cookies = new HashSet<String>(16);
    }

    /**
     * 设置代理
     * 
     * @Data:上午11:02:43
     * @Package:testhttpclient.testhttpclient
     * @Return:void
     * @Auth:diao
     */
    public void setProxy(String Address, int port) {
        proxy = new HttpHost(Address, port);
        requestconfig = RequestConfig.custom().setProxy(proxy).build();
    }

    /**
     * 释放请求资源
     * 
     * @Data:上午11:03:27
     * @Package:testhttpclient.testhttpclient
     * @Return:void
     * @Auth:diao
     */
    public void close() {
        if (cookies != null) {
            cookies = null;
        }
        if (proxy != null) {
            proxy = null;
        }
        if (resultmap != null) {
            resultmap = null;
        }

        if (httpclient != null) {
            try {
                httpclient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                httpclient = null;
            }
        }
    }

    /**
     * 处理http结果请求
     * 
     * @Data:下午1:42:28
     * @Package:testhttpclient.testhttpclient
     * @Return:Map<String,String>
     * @Auth:diao
     */
    public Map<String, String> getResData(HttpResponse response, HttpRequestBase requestbase) {
        int status = 405;
        if (response != null) {
            status = response.getStatusLine().getStatusCode();
            for (Header header : response.getAllHeaders()) {
                if ("Set-Cookie".equalsIgnoreCase(header.getName())) {
                    cookies.add(header.getValue());
                }
            }
        }
        resultmap = new HashMap<>(16);
        resultmap.put(HTTPRESULT, status + "");
        resultmap.put(HTTPRESULT, null);
        if (status != HttpStatusEnum.OK.code()) {
            requestbase.abort();

        } else {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    String data = EntityUtils.toString(entity, "utf-8");

                    String start = "[", end = "]";
                    if (data.startsWith(start)) {
                        data = data.substring(1);
                    }
                    if (data.endsWith(end)) {
                        data = data.substring(0, data.length() - 1);
                    }
                    data = data.replaceAll("\\\\t|\\\\n|\\r\\n", "");
                    data = data.replaceAll("\\\\/", "/");
                    data = decodeUnicode(data);
                    resultmap.put(HTTPRESULT, data);
                    // 关闭流
                    EntityUtils.consume(entity);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                response = null;
            }
        }
        return resultmap;
    }

    /**
     * unicode转中文
     * 
     * @Data:下午1:44:16
     * @Package:testhttpclient.testhttpclient
     * @Return:String
     * @Auth:diao
     */
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            // 16进制parse整形字符串。
            char letter = (char) Integer.parseInt(charStr, 16);
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    /**
     * 获取请求头
     * 
     * @Data:下午1:44:16
     * @Package:testhttpclient.testhttpclient
     * @Return:String
     * @Auth:diao
     */
    public Map<String, String> getCommHeader() {
        Map<String, String> headers = new HashMap<String, String>(16);
        headers.put("User-Agent", "Mozilla/5.0(Window NT 6.1; WOW64; rv:58.0) Gecko/20100101 Firfox/58.0");
        headers.put("Accept", "application/json,text/plain,*/*");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        headers.put("Accept-Encoding", "gzip,deflate");
        headers.put("Connection", "keep-alive");
        return headers;
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
    public abstract HttpResponse doGet(String url, Map<String, String> headers);

    /**
     * post请求方式
     * 
     * @Data:下午2:01:15
     * @Package:testhttpclient.testhttpclient
     * @Return:Map<String,String>
     * @Auth:diao
     */
    public abstract HttpResponse doPost(String url, Map<String, String> headers, Map<String, String> params, String charset)
            throws UnsupportedEncodingException;

    
    /**
     * post请求方式
     * 
     * @Data:下午2:01:15
     * @Package:testhttpclient.testhttpclient
     * @Return:Map<String,String>
     * @Auth:diao
     */
    public abstract HttpResponse doHead(String url, Map<String, String> headers, Map<String, String> params, String charset)
            throws UnsupportedEncodingException;

    
    
    // public void test(String ip,int port,String jobid)
    // {
    // String url=String.format("http://%s:%d/jobs/%s/yarn-cancel",ip,port,jobid);
    // HttpClientComm httpclient=new HttpClientComm();
    // Map<String,String>header=new HashMap<String, String>(16);
    // header.put("Host",ip+":"+port);
    // header.put("Referer","http://"+ip+":"+port);
    // Map<String,String>Resultmap=httpclient.doGet(url, header);
    // String httpstatus=Resultmap.get(httpclient.HTTPSTATUS);
    // String resultmap=Resultmap.get(httpclient.HTTPRESULT);
    // if(httpstatus.isEmpty()&&HttpStatusEnum.ACCEPTED.code()==Integer.parseInt(httpstatus))
    // {
    // //json解析
    //
    // }
    // }

}
