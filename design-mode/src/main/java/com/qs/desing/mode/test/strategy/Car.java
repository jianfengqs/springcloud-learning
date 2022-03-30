package com.qs.desing.mode.test.strategy;

public class Car implements ITrip{

    @Override
    public void trip() {
        System.out.println("开汽车");
    }
}
