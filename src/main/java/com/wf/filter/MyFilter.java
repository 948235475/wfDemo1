package com.wf.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    private String encoding; //编码可以通过<init-param>元素配置

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        if(encoding == null){//如果用户忘记配置，默认encoding为UTF-8
            encoding = "UTF-8";
        }
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器的"+request.getParameter("storeId"));
        //只能解决POST请求参数乱码问题
        request.setCharacterEncoding(encoding);
        //指定输出编码（最后带上，后面会有说明）
        response.setCharacterEncoding(encoding);
        //指定输出流编码及客户端应使用的码表
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        /*PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "过滤器生效";
        pw.write(s);
        pw.flush();
        pw.close();*/
        chain.doFilter(request, response);
    }

}
