package com.wf.ProxyInvoke;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class Invocation implements InvocationHandler {

    private Object object;

    public Invocation(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(object.getClass());
        Object result = method.invoke(object,args);
        return result;
    }

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        SubjectImpl subject = new SubjectImpl();
        InvocationHandler invocationHandler = new Invocation(subject);
        AllSubject subjectProxy = (AllSubject) Proxy.newProxyInstance(SubjectImpl.class.getClassLoader(),SubjectImpl.class.getInterfaces(),invocationHandler);
        System.out.println(subjectProxy.getClass().toString());
        subjectProxy.run();
        //生成$Proxy.class文件
        /*String path = "../$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", SubjectImpl.class.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }
}
