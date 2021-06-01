package com.datastructure.ds.stack;

/**
 * @author : tianyu.wang
 * create at:  2021/6/1  4:08 下午
 * @description: 链表实现
 */
public class Mystack2<T> {

    class Node<T> {
        private T t;
        private Node next;
    }

    private Node<T> head;

    Mystack2() {
        head = null;
    }

    //入栈
    public void push(){

    }
    //出栈
    public T pop(){
        T t=head.t;
        head=head.next;
        return t;
    }
    public T peek(){
        T t=head.t;
        return  t;
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        }else {
            return false;
        }
    }

}
