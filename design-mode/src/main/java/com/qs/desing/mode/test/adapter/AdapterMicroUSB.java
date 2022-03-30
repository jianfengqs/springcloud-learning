package com.qs.desing.mode.test.adapter;

public class AdapterMicroUSB implements MicroUSB {

    private ITypeC typeC;

    public AdapterMicroUSB(ITypeC typeC){
        this.typeC=typeC;
    }

    @Override
    public void charger() {
        typeC.charger();
    }
}
