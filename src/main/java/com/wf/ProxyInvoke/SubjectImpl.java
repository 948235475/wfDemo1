package com.wf.ProxyInvoke;

public class SubjectImpl implements Subject,AllSubject{
    @Override
    public void sayHello() {
        System.out.println("helloWord");
    }

    @Override
    public void run() {
        System.out.println("i'm run");
    }
}
