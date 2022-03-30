package com.qs.desing.mode.test.strategy;

public class Test {

    public static void main(String[] args) {

        Trip trip = new Trip(new Bike());
        trip.doTrip();

    }
}
