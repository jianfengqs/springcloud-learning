package com.qs.desing.mode.test;

public class Singleton {

    private static volatile Singleton singleton;

    public static synchronized Singleton getSingleton(){
        if(singleton==null){
            return new Singleton();
        }
        return singleton;
    }


}
