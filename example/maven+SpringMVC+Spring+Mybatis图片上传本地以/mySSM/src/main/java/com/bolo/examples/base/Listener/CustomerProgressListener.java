package com.bolo.examples.base.Listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class CustomerProgressListener implements ProgressListener{

	private HttpServletRequest request;
	
    public CustomerProgressListener(HttpServletRequest request) {
        this.request = request;
    } 
    
   
    public void update(long bytesRead, long contentLength, int items) {
        //将百分比保存到session中
        double percentage = ((double) bytesRead / (double) contentLength);
        HttpSession session = this.request.getSession();
        session.setAttribute("percentage", percentage);
    }
    
    
}
