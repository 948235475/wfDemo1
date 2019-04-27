package com.wf.controller;

import com.wf.dao.impl.StoreSettingDaoImpl;
import com.wf.excel.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ExportExcelController {

    @Resource
    private StoreSettingDaoImpl storeSettingDao;
    @RequestMapping("/exportExcel")
    public void excel(HttpServletResponse response){
        ExcelUtil.exportExcel(response,storeSettingDao.findAll());
    }
}
