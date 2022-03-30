package com.qs.desing.mode.test.chainOfResponsibility;

public abstract class Leader {

    private Leader leader;

    public void setLeader(Leader leader){
        this.leader=leader;
    }

    public Leader getLeader(){
        return this.leader;
    }

    public abstract void handleRequest(int leaveDays);

}
