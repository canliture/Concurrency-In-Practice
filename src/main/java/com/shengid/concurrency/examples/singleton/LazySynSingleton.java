package com.shengid.concurrency.examples.singleton;

import com.shengid.concurrency.annotations.NotRecommend;
import com.shengid.concurrency.annotations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class LazySynSingleton {

    // 私有构造
    private LazySynSingleton(){ }

    private static LazySynSingleton instance;

    public static synchronized LazySynSingleton getInstance(){
        if(instance == null){
            instance = new LazySynSingleton();
        }
        return instance;
    }
}
