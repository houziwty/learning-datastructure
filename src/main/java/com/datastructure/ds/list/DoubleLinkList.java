package com.datastructure.ds.list;


/**
 * @author : tianyu.wang
 * create at:  2021/1/5  2:46 下午
 * @description:
 */
public class DoubleLinkList {
    private DNode head;
    private DNode tail;

    DoubleLinkList() {
        head = null;
        tail = null;
    }

    public void insertHead(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            tail = newNode;
        } else {
            head.pre = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public void deleteHead() {
        if (head == null) return;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.pre = null;
        }
        head = head.next;
    }

    public void deleteKey(int data) {
        DNode current = head;
        while (current.value != data) {
            if (current.next == null) {
                System.out.println("没有");
                return;
            }
            current=current.next;
        }
        if(current==head){// 指向下个就表示删除第一个
            deleteHead();
        }else{
            current.pre.next=current.next;
            if(current==tail){//删除的是尾部
                tail=current.pre;
                current.pre=null;
            }else{
                current.next.pre=current.pre;
            }
        }

    }

    class DNode {
        int value; //值
        DNode next; //下一个指针
        DNode pre;//指向前一个指针

        DNode(int value) {
            this.value = value;
            this.next = null;
            this.pre = null;
        }
    }
}
