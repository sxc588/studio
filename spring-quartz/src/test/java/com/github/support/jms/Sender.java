package com.github.support.jms;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.client.HttpClient;

class Sender implements Runnable {
    public static AtomicInteger count = new AtomicInteger(0);
    HttpClient httpClient;

    public Sender(HttpClient client) {
        httpClient = client;
    }

    public void run() {
        //    try {
                System.out.println(Thread.currentThread().getName()+"---Send message-"+count.getAndIncrement());
            //    PostMethod post = new PostMethod("http://127.0.0.1:8080/SendMessage");
              //  post.addParameter("msg", "Hello world!");
              //  httpClient.executeMethod(post);
                System.out.println(Thread.currentThread().getName()+"---Send message Success-"+count.getAndIncrement());

        //    } catch (IOException e) {
         //       e.printStackTrace();
          //  }
        }
    }