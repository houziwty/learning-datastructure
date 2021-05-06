package com.datastructure.ds.queue;

/**
 * @author : tianyu.wang
 * create at:  2021/3/1  5:18 下午
 * @description:单项队列
 */
public class LinkedQueue<E> implements Queue<E> {

    //构建node
    private static class Node<E> {
        private E data;
        //下一个链表
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;//队头指针
    private Node<E> tail;//队尾指针

    private int size;//队列元素数量

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node<E> prev = tail;
        //赋值进入队尾
        tail = new Node<>(e, null);
        //如果为空 头部等于队尾 否则下一个节点指向队尾
        if (size == 0)
            head = tail;
        else
            prev.next = tail;
        //队列size++
        size++;

    }

    @Override
    public E dequeue() {
        //出队列
        if (size == 0) {
            throw new RuntimeException("队列为空...");
        }
        //结果赋值为头部
        E result = head.data;
        //头部赋值下一个指针
        head = head.next;
        //size--
        size--;
        //如果等于空 尾部为空
        if (size == 0)
            tail = null;
        return result;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new RuntimeException("队列为空...");
        }
        return head.data;
    }
}
