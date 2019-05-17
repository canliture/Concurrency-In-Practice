package com.shengid.concurrency.examples.singleton;

public class StarvingSingleton {

    private StarvingSingleton() { }

    private static StarvingSingleton instance = new StarvingSingleton();

    public static StarvingSingleton getInstance(){
        return instance;
    }
}
