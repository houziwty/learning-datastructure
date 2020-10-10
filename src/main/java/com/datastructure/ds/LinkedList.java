package com.datastructure.ds;

public class LinkedList<E> implements List<E> {

    private class Node {
        private E data;//数据域
        private Node next; //指针域，指向下一个Node

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public String toString() {
            return data.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E o) {
        Node p = head;
        while (p != null) {
            if (p.data.equals(o))
                return true;
            p = p.next;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        int reuslt = -1;
        Node p = head;
        int i = 0;
        while (p != null) {
            if (p.data.equals(e)) {
                reuslt = i;
                break;
            }
            p = p.next;
            i++;
        }
        return reuslt;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("非法下标...");
        }
        Node p = head;
        for (int i = 0; i < index; i++)
            p = p.next;
        return p.data;
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("非法下标...");
        }
        Node p = head;
        for (int i = 0; i < index; i++)
            p = p.next;
        p.data = e;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("下标越界.....");
        }
        //插到链表头部
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }

    }

    public void addFirst(E e) {
        Node node = new Node(e, head);
        head = node;
        size++;
    }

    public void addLast(E e) {
        Node node = new Node(e, null);

        //链表为空
        if (head == null) {
            head = node;
        } else {
            Node prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = node;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("非法下标...");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            Node tmp = prev.next;
            prev.next = tmp.next;
            tmp.next = null;
            size--;
            return tmp.data;
        }

    }

    public E removeFirst() {
        if (head == null)
            return null;
        E result = head.data;
        head = head.next;
        size--;
        return result;
    }

    public E removeLast() {
        if (head == null)
            return null;
        E result;
        //链表只有一个节点
        if (head.next == null) {
            result = head.data;
            head = null;
        } else {
            Node prev = head;
            while (prev.next.next != null)
                prev = prev.next;
            result = prev.next.data;
            prev.next = null;
        }
        size--;
        return result;
    }

}
