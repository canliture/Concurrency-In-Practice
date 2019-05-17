package com.shengid.concurrency.examples.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Starving2Singleton {

    private Starving2Singleton() { }

    static {
        instance = new Starving2Singleton();
    }

    private static Starving2Singleton instance;

    public static Starving2Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {

        log.info("Instance1, {}", getInstance());
        log.info("Instance2, {}", getInstance());
    }
}
