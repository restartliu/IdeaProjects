package com.transport.utils;

import com.alibaba.fastjson.JSON;
import com.transport.model.TransFile;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataAccessUtils {

    public String searchDirectory(String filepath){
        TransFile transFile = new TransFile(filepath);
        String[] list = null;
        if (transFile.isDirectory()) {
            list = transFile.list();
        }
        return JSON.toJSONString(list);
    }

    public Boolean downloadFile(String filepath, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println(filepath);
        TransFile transFile = new TransFile(filepath);
        System.out.println(transFile.exists());
        if ( transFile.exists() && !transFile.isDirectory()){
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(transFile.getName(), "UTF-8"));

            byte[] buffer = new byte[1024];
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;
            try{
                fileInputStream = new FileInputStream(transFile);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                OutputStream os = response.getOutputStream();
                int i = bufferedInputStream.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bufferedInputStream.read(buffer);
                }
                System.out.println("hello world");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String videoLoad(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");

        File src = new File("E:\\360Downloads\\data");
        File[] files = src.listFiles();
        List<String> filePaths = new LinkedList<>();
        PrintWriter writer = response.getWriter();
        assert files != null;
        Arrays.stream(files).forEach(w->filePaths.add(w.getPath()));
        Iterator<File> iterator = Arrays.stream(files).iterator();
        while (iterator.hasNext()) {
            File next = iterator.next();
            writer.write("<a href=\""+next.getName()+"\">"+next.getName()+"</a><br/>");
        }
        writer.flush();
        writer.close();
        return "success";
    }
}
