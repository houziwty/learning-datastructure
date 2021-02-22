package com.datastructure.ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author : tianyu.wang
 * create at:  2021/2/7  5:52 下午
 * @description:
 */
public class ArrayStackOne<E> implements Stack<E> {

    private final static int DEFAULT_CAPACITY = 10;

    //保存栈元素的数组
    private E[] data;

    //栈中元素数量
    private int size;

    //栈顶索引
    private int top;

    public ArrayStackOne(int capacity) {
        this.size = 0;
        this.top = -1;
        this.data = (E[]) new Object[capacity];
    }

    public ArrayStackOne() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public Stack<E> push(E e) {
        if (data.length == size) {
            grow(size * 2);
        }
        data[++top] = e;
        size++;
        return null;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        if(size<data.length/2){
            grow(data.length/2);
        }
        return data[top--];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        if(size==0){
            throw new EmptyStackException();
        }
        return data[top];
    }

    /***
     * @params [capacity]
     * @return void
     * @description 扩容
     * @author tianyu.wang
     * @date 2021/2/14 4:10 下午
     */
    private void grow(int capacity) {
        if (capacity <= DEFAULT_CAPACITY)
            return;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args){
        Stack<Integer> stack=new ArrayStackOne<>();
        for(int i=0;i<20;i++){
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        for(int i=0; i<18; i++) {
            System.out.println("The element is: " + stack.pop());
        }
    }
}
