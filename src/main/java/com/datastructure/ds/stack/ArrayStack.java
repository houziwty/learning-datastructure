package com.datastructure.ds.stack;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author : tianyu.wang
 * create at:  2021/1/26  2:40 下午
 * @description:
 */
public class ArrayStack<Item> implements MyStack<Item> {

    //最好就是开始的时候就设置大小
    private Item[]a= (Item[]) new Objects[1];

    //大小 初始的元素个数
    private int n=0;

    public ArrayStack(int cap){
        a= (Item[]) new Object[cap];
    }

    @Override
    public MyStack<Item> push(Item item) {
        return null;
    }

    @Override
    public Item pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
