package com.datastructure.limt;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.lang.annotation.Annotation;
import java.util.Random;

/**
 * @author : tianyu.wang
 * create at:  2021/5/28  2:43 下午
 * @description: 限流
 */

public class HystrixConfig  {

    public static void main(String[] args) {
        HystrixConfig config = new HystrixConfig();
        System.out.println(config.call());


    }




    @HystrixCommand(
            fallbackMethod = "callback")
    public  String call() {
        Random random = new Random(10000);
        int i = random.nextInt(10000);
        System.out.println("Time:" + i);
        try {

            Thread.sleep(-2000);
            return "success";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String callback() {
        return "error";
    }



}
