package com.datastructure.ds.stack;

/**
 * @author : tianyu.wang
 * create at:  2021/6/1  4:08 下午
 * @description: 链表实现
 */
public class Mystack2<T> {

    public static void main(String[] args) {
        Mystack2<String> stack = new Mystack2<>();
//        System.out.println(stack.peek());
//        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }

    class Node<T> {
        private T t;
        private Node next;
    }

    private Node<T> head;

    Mystack2() {
        head = null;
    }

    //入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("参数不能为空");
        }
        if (head == null) {
            head = new Node<T>();
            head.t = t;
            head.next = null;
        } else {
            Node<T> temp = head;
            head = new Node<>();
            head.t = t;
            head.next = temp;
        }
    }

    //出栈
    public T pop() {
        T t = head.t;
        head = head.next;
        return t;
    }

    public T peek() {
        T t = head.t;
        return t;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

}
