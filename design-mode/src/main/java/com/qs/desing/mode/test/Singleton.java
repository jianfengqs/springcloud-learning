package com.qs.desing.mode.test;

public class Singleton {

    private static   Singleton singleton;

    public static synchronized Singleton getSingleton(){
        if(singleton==null){
            return new Singleton();
        }
        return singleton;
    }


    public static void main(String[] args) {
        Singleton singleton = getSingleton();
        Singleton singleton1 = getSingleton();

        System.out.println(singleton1==singleton);

    }


}
