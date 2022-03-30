package com.qs.desing.mode.test.chainOfResponsibility;

public class Dean extends Leader{
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays<=10){
            System.out.println("院长处理，假期为"+leaveDays+"天");
        }else {
            if (getLeader()!=null){
                getLeader().handleRequest(leaveDays);
            }else {
                System.out.println("没有找到处理人");
            }
        }
    }
}
