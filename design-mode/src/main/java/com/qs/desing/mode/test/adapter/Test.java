package com.qs.desing.mode.test.adapter;

public class Test {


    public static void main(String[] args) {
        AdapterMicroUSB adapterMicroUSB = new AdapterMicroUSB(new TypeCImpl());
        adapterMicroUSB.charger();


    }

}
