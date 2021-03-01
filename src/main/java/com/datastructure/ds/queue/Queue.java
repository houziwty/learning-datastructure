package com.datastructure.ds.queue;

/**
 * @author : tianyu.wang
 * create at:  2021/3/1  5:16 下午
 * @description:
 */
public interface Queue<E> {

    //返回队列元素数量
    int size();

    //队列是否为空
    boolean empty();

    //入队
    void enqueue(E e);

    //出队
    E dequeue();

    //查看队首元素
    E peek();
}
