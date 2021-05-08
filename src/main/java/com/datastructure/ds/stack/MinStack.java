package com.datastructure.ds.stack;

/**
 * @author : tianyu.wang
 * create at:  2021/5/8  2:10 下午
 * @description:最小栈
 */
public class MinStack {

    class  ListNode{
        public int val;
        public int min;//最小值

        public ListNode next;
        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    //链表头，相当于栈顶
    private ListNode head;


}
