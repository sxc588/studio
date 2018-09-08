package com.github.support.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginCheck {
    
    public static String check(String username,String password){
        try {
//            Connection conn = Dao.getConnection();
//            PreparedStatement p = conn.prepareStatement("select * from user_t where user_name=? and password=?");
//            p.setString(1, username);
//            p.setString(2, password);
//            ResultSet rs = p.executeQuery();
//            if(rs.next()){
//                String user_name = rs.getString("user_name");
//                Dao.close(rs, p, conn);
//                return user_name;
//            }
//            Dao.close(rs, p, conn);
        	return "dd";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}