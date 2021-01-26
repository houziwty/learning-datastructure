package com.datastructure.ds.stack;

/**
 * @author : tianyu.wang
 * create at:  2021/1/26  2:32 下午
 * @description:
 */
public interface MyStack<Item> {

    //入栈
    MyStack<Item>push(Item item);

    //出栈
    Item pop();

    //大小
    int size();

    boolean isEmpty();

}
