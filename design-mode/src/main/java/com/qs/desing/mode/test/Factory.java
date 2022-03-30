package com.qs.desing.mode.test;

public class Factory {

    public static String getFactory(String product){
        String result=null;

        switch (product){
            case "moka":
                result="摩卡";
                break;
            case "kafei":
                result="咖啡";
                break;
            default:
                result="未实现";
                break;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(getFactory("moka"));


    }


}
