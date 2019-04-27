package com.wf.interceptor;

import com.wf.dao.impl.StoreSettingDaoImpl;
import com.wf.model.StoreSetting;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class DerailInterceptor implements HandlerInterceptor {

    @Resource
    private StoreSettingDaoImpl storeSettingDao;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*int storeId = Integer.parseInt(request.getParameter("storeId"));
        StoreSetting storeSetting = storeSettingDao.findSetting(storeId);
        System.out.println(storeSetting.getDerail());*/
        /*if(storeSetting == null ){
            System.out.println("请打开开关");
            return DerailInterceptor.result(response);
        }else if(storeSetting.getDerail() == 0){
            System.out.println("请打开开关");
            return DerailInterceptor.result(response);
        }*/
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    public static boolean result(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "请打开开关";
        pw.write(s);
        pw.flush();
        pw.close();
        return false;
    }
}
