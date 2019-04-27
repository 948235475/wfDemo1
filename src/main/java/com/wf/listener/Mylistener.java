package com.wf.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Mylistener implements HttpSessionListener {

    public int count = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        System.out.println("在线人数增加 "+count);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        System.out.println("在线人数减少"+count);
    }
}
