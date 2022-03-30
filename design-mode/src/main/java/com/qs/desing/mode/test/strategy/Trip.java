package com.qs.desing.mode.test.strategy;

public class Trip {

    private ITrip iTrip;

    public Trip(ITrip iTrip){
        this.iTrip=iTrip;
    }

    public void doTrip(){
        iTrip.trip();
    }

}
