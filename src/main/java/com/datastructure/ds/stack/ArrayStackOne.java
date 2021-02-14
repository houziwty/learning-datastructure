package com.datastructure.ds.stack;

import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/2/7  5:52 下午
 * @description:
 */
public class ArrayStackOne<E> implements Stack<E> {

    private  final static  int DEFAULT_CAPACITY=10;

    //保存栈元素的数组
    private E[]data;

    //栈中元素数量
    private int size;

    //栈顶索引
    private int top;

    public ArrayStackOne(int capacity){
        this.size = 0;
        this.top = -1;
        this.data = (E[]) new Object[capacity];
    }

    public ArrayStackOne() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public Stack<E> push(E e) {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        return null;
    }

    private void grow(int capacity){
        if(capacity<=DEFAULT_CAPACITY)
            return;
        data= Arrays.copyOf(data,capacity);
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
