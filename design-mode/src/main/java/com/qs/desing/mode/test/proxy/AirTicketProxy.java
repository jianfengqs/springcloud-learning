package com.qs.desing.mode.test.proxy;

public class AirTicketProxy implements IAirTicket{

    private AirTicket airTicket;

    public AirTicketProxy(){
        airTicket=new AirTicket();
    }

    @Override
    public void buy() {
        airTicket.buy();
    }
}
