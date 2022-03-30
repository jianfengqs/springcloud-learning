package com.qs.desing.mode.test.chainOfResponsibility;

public class ClassAdviser extends Leader{
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays<=3){
            System.out.println("班主任处理，假期为"+leaveDays+"天");
        }else {
            if (getLeader()!=null){
                getLeader().handleRequest(leaveDays);
            }else {
                System.out.println("没有找到处理人");
            }
        }
    }
}
