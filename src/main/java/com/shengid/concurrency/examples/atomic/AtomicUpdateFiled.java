package com.shengid.concurrency.examples.atomic;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

@Slf4j
public class AtomicUpdateFiled {

    private static AtomicIntegerFieldUpdater<AtomicUpdateFiled> updater =
                        AtomicIntegerFieldUpdater.newUpdater(AtomicUpdateFiled.class, "count");

    @Getter
    public volatile int count = 100; // 不能用static修饰

    private static AtomicUpdateFiled cls = new AtomicUpdateFiled();

    public static void main(String[] args) {
        if( updater.compareAndSet(cls, 100, 200) ){
            log.info("update success 1, {}", cls.getCount());
        }

        if( updater.compareAndSet(cls, 100, 200) ){
            log.info("update success 2, {}", cls.getCount());
        } else {
            log.info("update fail, {}", cls.getCount());
        }

    }
}
