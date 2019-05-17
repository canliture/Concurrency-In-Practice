package com.shengid.concurrency.examples.count;

import com.shengid.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
public class AtomicCountTest {

    public final static int MAX_CLIENTS = 5000;

    public final static int MAX_THREADS = 200;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String... args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(MAX_THREADS); // 并发量
        final CountDownLatch countDownLatch = new CountDownLatch(MAX_CLIENTS);
        for(int i = 0 ; i < MAX_CLIENTS ; i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception", e);
                }
                countDownLatch.countDown(); // 每执行完一个线程就countdown
            });
        }
        countDownLatch.await(); // 等待所有客户执行完
        executorService.shutdown();
        log.info("Count: {}", count.get());
    }

    private static void add(){
        count.incrementAndGet();
        // or count.getAndIncrement();
    }

}
