package com.shengid.concurrency.examples.singleton;

public class LazySingleton {

    // 私有构造
    private LazySingleton(){ }

    private static LazySingleton lazySingleton;

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
