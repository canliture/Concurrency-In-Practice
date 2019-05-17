package com.shengid.concurrency.examples.singleton;

import com.shengid.concurrency.annotations.NotThreadSafe;

@NotThreadSafe
public class LazySyn2Singleton {

    // 私有构造
    private LazySyn2Singleton(){ }

    private static LazySyn2Singleton instance;

    public static LazySyn2Singleton getInstance(){
        if(instance == null){
            synchronized (LazySyn2Singleton.class){
                if(instance == null){
                    instance = new LazySyn2Singleton();
                }
            }
        }
        return instance;
    }
}
