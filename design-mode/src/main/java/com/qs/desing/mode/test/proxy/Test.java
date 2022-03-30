package com.qs.desing.mode.test.proxy;

public class Test {

    public static void main(String[] args) {
        IAirTicket airTicket = new AirTicketProxy();
        airTicket.buy();


    }


}
