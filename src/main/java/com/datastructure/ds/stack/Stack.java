package com.datastructure.ds.stack;

/**
 * @author : tianyu.wang
 * create at:  2021/1/26  2:32 下午
 * @description:
 */
public interface Stack<Item> {

    //入栈
    Stack<Item> push(Item item);

    //出栈
    Item pop();

    //大小
    int size();

    //查看栈顶元素（不弹栈）
    public Item peek();

    boolean isEmpty();

}
