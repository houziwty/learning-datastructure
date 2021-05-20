package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/5/8  2:10 下午
 * @description:最小栈
 */
public class MinStack {

    class ListNode {
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

    ////压栈，需要判断栈是否为空
    public void push(int x) {
        if (empty()) {
            head = new ListNode(x, x, null);
        } else {
            head = new ListNode(x, Math.min(x, head.min), head);
        }
    }

    //出栈，相当于把链表头删除
    public void pop() {
        if (empty()) {
            throw new IllegalStateException("栈为空……");
        }
        head = head.next;

    }

    //栈顶的值也就是链表头的值
    public int top() {
        if (empty())
            throw new IllegalStateException("栈为空...");
        return head.val;
    }

    public int getMin(){
        if (empty())
            throw new IllegalStateException("栈为空...");
        return head.min;
    }

    public boolean empty() {
        return head == null;
    }


}
