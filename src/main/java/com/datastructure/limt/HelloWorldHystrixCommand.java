package com.datastructure.limt;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;

import java.lang.annotation.Annotation;

/**
 * @author : tianyu.wang
 * create at:  2021/5/28  3:12 下午
 * @description:
 */
public class HelloWorldHystrixCommand implements HystrixCommand {
    @Override
    public String groupKey() {
        return null;
    }

    @Override
    public String commandKey() {
        return null;
    }

    @Override
    public String threadPoolKey() {
        return null;
    }

    @Override
    public String fallbackMethod() {
        return null;
    }

    @Override
    public HystrixProperty[] commandProperties() {
        return new HystrixProperty[0];
    }

    @Override
    public HystrixProperty[] threadPoolProperties() {
        return new HystrixProperty[0];
    }

    @Override
    public Class<? extends Throwable>[] ignoreExceptions() {
        return new Class[0];
    }

    @Override
    public ObservableExecutionMode observableExecutionMode() {
        return null;
    }

    @Override
    public HystrixException[] raiseHystrixExceptions() {
        return new HystrixException[0];
    }

    @Override
    public String defaultFallback() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
