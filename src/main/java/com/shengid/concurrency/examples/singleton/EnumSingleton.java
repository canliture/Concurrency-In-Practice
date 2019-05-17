package com.shengid.concurrency.examples.singleton;

import com.shengid.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class EnumSingleton {

    private EnumSingleton() {
    }

    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private EnumSingleton instance;

        // JVM保证这个方法绝对只调用一次
        Singleton(){
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return instance;
        }
    }
}
