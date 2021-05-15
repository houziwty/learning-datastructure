package com.datastructure.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author : tianyu.wang
 * create at:  2021/3/10  2:12 下午
 * @description:
 */
public class Latch {
    public static void main(String[] args) {
//        testCountDownLatch();
//        testCyclicBarrier();

        testSemapore();
    }

    static void testSemapore(){
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }
    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void testCyclicBarrier() {
        int n = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n);
        for (int i = 0; i < n; i++) {
            new Thread(new TestCyclicBarrier(cyclicBarrier)).start();
        }
    }

    public static class TestCyclicBarrier implements Runnable {
        CyclicBarrier cyclicBarrier;
        public TestCyclicBarrier(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier=cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }

    static void testCountDownLatch() {
        try {
            CountDownLatch latch = new CountDownLatch(2);
            new Thread(new TestCountDownLatch(latch)).start();
            new Thread(new TestCountDownLatch(latch)).start();
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static class TestCountDownLatch implements Runnable {
        CountDownLatch latch;

        public TestCountDownLatch(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
