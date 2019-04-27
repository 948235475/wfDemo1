package com.wf.controller;

import com.wf.Exception.MyException;
import com.wf.dao.impl.StoreSettingDaoImpl;
import com.wf.enums.ErrorEnum;
import com.wf.model.StoreSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/derail")
public class FindDerail {

    private static final Logger logger = LoggerFactory.getLogger(FindDerail.class);

    @Resource
    private StoreSettingDaoImpl storeSettingDao;

    @RequestMapping("/finderail")
    public String finderail(HttpServletRequest request) {
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        StoreSetting storeSetting = null;
        int a = 0;
        System.out.println(1/0);
        if (a == 0){
            throw new MyException(ErrorEnum.MY_ERROR);
        }
        storeSetting = storeSettingDao.findSetting(storeId);
        logger.info("info ={}",storeId);
        System.out.println(storeSetting.getDerail());
        return "OK";
    }
}
