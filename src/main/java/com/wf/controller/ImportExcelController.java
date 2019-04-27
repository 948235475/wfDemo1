package com.wf.controller;

import com.wf.dao.impl.StoreSettingDaoImpl;
import com.wf.excel.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ImportExcelController {

    @Resource
    private StoreSettingDaoImpl storeSettingDao;
    @RequestMapping("/importExcel")
    public void excel(HttpServletResponse response, @RequestParam("file") MultipartFile file){
        System.out.println(ExcelUtil.importExcel(file));
    }
}
