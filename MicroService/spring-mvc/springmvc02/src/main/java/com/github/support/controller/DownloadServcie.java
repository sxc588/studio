package com.github.support.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DownloadServcie
{
//	@Override
//    public String testDownload(HttpServletRequest request, HttpServletResponse response, PieceCostParam pieceCostParam) throws Exception{
//        String fileName="excel文件";
//        
//        
//        //填充projects数据
//        List<PieceCostVO> projects = costRelatedService.getAllPieceCost(pieceCostParam);
//        
//        List<Map<String,Object>> list = createExcelRecord(projects);
//        
//        
//        String columnNames[]={"序号","机构名称","购买时间","数据包名称","购买线索条数","线索单价","线索收费"};//列名
//        String keys[]       ={"id","name","purcahseTime","packName","num","cost","sumcost"};//map中的key
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] content = os.toByteArray();
//        InputStream is = new ByteArrayInputStream(content);
//        // 设置response参数，可以打开下载页面
//        response.reset();
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
//        ServletOutputStream out = response.getOutputStream();
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            bis = new BufferedInputStream(is);
//            bos = new BufferedOutputStream(out);
//            byte[] buff = new byte[2048];
//            int bytesRead;
//            // Simple read/write loop.
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//            }
//        } catch (final IOException e) {
//            throw e;
//        } finally {
//            if (bis != null)
//                bis.close();
//            if (bos != null)
//                bos.close();
//        }
//        return null;
//    }
//
//
//    private List<Map<String, Object>> createExcelRecord(List<PieceCostVO> projects) {
//        
//    	List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
//        
//        
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("sheetName", "sheet1");
//        listmap.add(map);
//        PieceCostVO project=null;
//        
//        for (int j = 0; j < projects.size(); j++) {
//            project=projects.get(j);
//            Map<String, Object> mapValue = new HashMap<String, Object>();
//            mapValue.put("id", j);
//            mapValue.put("name", project.getCompanyName());
//            mapValue.put("purcahseTime", project.getPurchaseTime());
//            mapValue.put("packName", project.getDataPackName());
//            mapValue.put("num", project.getDataSum());
//            mapValue.put("cost", project.getDataCost());
//            mapValue.put("sumcost", project.getCostSum());
//            listmap.add(mapValue);
//        }
//        return listmap;
//    }
}