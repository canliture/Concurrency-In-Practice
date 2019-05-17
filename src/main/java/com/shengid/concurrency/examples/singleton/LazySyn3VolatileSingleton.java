package com.shengid.concurrency.examples.singleton;

import com.shengid.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class LazySyn3VolatileSingleton {
    // 私有构造
    private LazySyn3VolatileSingleton(){ }

    // 使用volatile关键字
    private volatile  static LazySyn3VolatileSingleton instance;

    public static LazySyn3VolatileSingleton getInstance(){
        if(instance == null){
            synchronized (LazySyn2Singleton.class){
                if(instance == null){
                    instance = new LazySyn3VolatileSingleton();
                }
            }
        }
        return instance;
    }
}
