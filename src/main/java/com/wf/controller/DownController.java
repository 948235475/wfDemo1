package com.wf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class DownController {

    @RequestMapping("down")
    public void down(HttpServletResponse response){
        File file = new File("c:/study/upload/logo.jpg");
        FileInputStream fis = null;
        BufferedInputStream bufferedInputStream;
        OutputStream outputStream = null;
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + "aa.jpg");// 设置文件名
        try {
            fis = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fis);
            System.out.println(bufferedInputStream.available());
            outputStream = response.getOutputStream();
            byte[] buffer = new byte[20480];
            int len = bufferedInputStream.read(buffer);
            if (len !=-1){
                outputStream.write(buffer,0,len);
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
