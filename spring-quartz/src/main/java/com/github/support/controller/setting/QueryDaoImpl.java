package com.github.support.controller.setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.github.support.controller.setting.dao.QueryDao;


@Repository
public class QueryDaoImpl implements QueryDao {
    private static Logger logger = LoggerFactory.getLogger(QueryDaoImpl.class);

    @Override
    public String selectSql(String sql) {
        DataSource ds = null;
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        int index = 1;
        //1 获得连接
        try {

            if(sql == null){
                return null;
            }

            InitialContext initialContext = new InitialContext();
            ds = (DataSource) initialContext.lookup("jdbc/account-structure");
            if (ds != null) {
                conn = ds.getConnection();
            }
            if(!sql.contains(";")){
                sql=sql+";";
            }
            if(!sql.contains("limit") && !sql.contains("LIMIT")){
                if(sql.contains(";")){
                    sql = sql.replaceAll(";", "");
                }
                sql = sql + " limit 0, 1;";
            }
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<LinkedHashMap<String, Object>> values = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            LinkedHashMap<String, Object> map = null;
            while (rs.next()) {
                //把一条记录放入Map中
                map = new LinkedHashMap<String, Object>();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Object value = rs.getObject(i + 1);
                    map.put(columnLabel, value);
                }
                values.add(map);
            }

            if (values.size() > 0) {
                for (LinkedHashMap<String, Object> m : values) {
                    Set<String> set = m.keySet();
                    for (String s : set) {
                        sb.append(s + ";");
                    }
                }

            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6关闭资源
//            JDBCUtils.close(conn, pstmt, rs);
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    pstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    rs.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }


    @Override
    public String selectSql1(String sql) {
        DataSource ds = null;
        Connection conn = null;
        java.sql.PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        int index = 0;
        //1 获得连接
        try {

            if(sql == null){
                return null;
            }

            InitialContext initialContext = new InitialContext();
            ds = (DataSource) initialContext.lookup("jdbc/account-structure");
            if (ds != null) {
                conn = ds.getConnection();
            }
            if(!sql.contains(";")){
                sql=sql+";";
            }
            if(!sql.contains("limit") && !sql.contains("LIMIT")){
                if(sql.contains(";")){
                    sql = sql.replaceAll(";", "");
                }
                sql = sql + "  limit 0, 5000;";
            }
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<LinkedHashMap<String, Object>> values = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            LinkedHashMap<String, Object> map = null;
            while (rs.next()) {
                //把一条记录放入Map中
                map = new LinkedHashMap<String, Object>();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Object value = rs.getObject(i + 1);
                    map.put(columnLabel, value);
                }
                values.add(map);
            }

            if (values.size() > 0) {
                for (LinkedHashMap<String, Object> m : values) {
                    Set<String> set = m.keySet();
                    for (String s : set) {
                        sb.append(s + ";");
                    }
                    sb.append("|"+index++);
                }

            }

            return String.valueOf(index);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6关闭资源
//            JDBCUtils.close(conn, pstmt, rs);
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    pstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    rs.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public String selectSq2(String sql, Integer page, Integer rows) {
        DataSource ds = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        int index = 1;
        //1 获得连接
        try {

            InitialContext initialContext = new InitialContext();
            ds = (DataSource) initialContext.lookup("jdbc/account-structure");
            if (ds != null) {
                conn = ds.getConnection();
            }
            String sql1=null;
            StringBuffer sql2=null;
            if(!sql.contains(";")){
                sql=sql+";";
            }
            sql1=sql.substring(0,sql.length()-1);

            sql2=sb1.append(sql1+" "+"limit"+" "+"?"+","+"?;");
            pstmt = conn.prepareStatement(sql2.toString());
            int startIndex = (page - 1) * rows;
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,rows);
            rs = pstmt.executeQuery();
            List<LinkedHashMap<String, Object>> values = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            LinkedHashMap<String, Object> map = null;
            while (rs.next()) {
                //把一条记录放入Map中
                map = new LinkedHashMap<String, Object>();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Object value = rs.getObject(i + 1);
                    map.put(columnLabel, value);
                }
                values.add(map);
            }

            if (values.size() > 0) {
                for (LinkedHashMap<String, Object> m : values) {
                    Set<String> set = m.keySet();

                    for (String s : set) {
                        sb.append(m.get(s) + ";");
                    }
                    sb.append("%");
                }
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    pstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    rs.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }
}