package com.wf.controller;

import com.wf.dao.impl.StoreSettingDaoImpl;
import com.wf.model.StoreSetting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UpdateDerail {

    @Resource
    private StoreSettingDaoImpl storeSettingDao;

    @RequestMapping("/updateDerail")
    public String updateDerail(HttpServletRequest request, HttpSession session){
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int derail = Integer.parseInt(request.getParameter("derail"));
        session.setAttribute("storeId",storeId);
        storeSettingDao.updateDerail(storeId,derail);
        return "OK";
    }
}
