package com.qs.desing.mode.test.template;

public abstract class TemplateMethod {


    public void open(){
        System.out.println("打开冰箱");
    }

    public abstract void put();

    public void close(){

        System.out.println("关闭冰箱");
    }

}
