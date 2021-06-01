package com.datastructure.ds.stack;

import com.google.inject.internal.cglib.core.$CollectionUtils;

import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/6/1  3:58 下午
 * @description:数组实现
 */
public class MyStack1<T> {

    Object[] stack;

    int size;

    MyStack1() {
        stack = new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //返回栈顶元素
    public T peek() {
        T t = null;
        if (size > 0)
            t = (T) stack[size - 1];
        return t;
    }

    public void push(T t) {
        expandCapacity(size + 1);
        stack[size] = t;
        size++;
    }

    public T pop(){
        T t=peek();
        if(size>0){
            stack[size-1]=null;
            size--;
        }
        return t;
    }


    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }

    public static void main(String[] args) {
        MyStack1<String> stack = new MyStack1<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }


}
