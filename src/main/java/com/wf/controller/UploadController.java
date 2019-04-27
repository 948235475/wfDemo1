package com.wf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            return "请选择文件";
        }
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "c:/study/upload/";
        String path = filePath + fileName;
        File file1 = new File(path);
        if (!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try {
            file.transferTo(file1);
            return "上传成功";
        } catch (IOException e) {
            return "上传失败";
        }
    }
}
