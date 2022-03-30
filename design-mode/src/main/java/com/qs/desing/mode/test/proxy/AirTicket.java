package com.qs.desing.mode.test.proxy;

public class AirTicket implements IAirTicket{
    @Override
    public void buy() {
        System.out.println("买票");
    }
}
