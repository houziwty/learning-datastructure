package com.datastructure.ds.list;

/**
 * @author : tianyu.wang
 * create at:  2021/4/29  9:48 下午
 * @description: 翻转反转一个单链表。
 * 解法1:迭代，重复某一过程，每一次处理结果作为下一次处理的初始值，这些初始值类似于状态、每 次处理都会改变状态、直至到达最终状态
 * 从前往后遍历链表，将当前节点的next指向上一个节点，因此需要一个变量存储上一个节点prev，当前 节点处理完需要寻找下一个节点，
 * 因此需要一个变量保存当前节点curr，处理完后要将当前节点赋值给 prev，并将next指针赋值给curr，因此需要一个变量提前保存下一个节点的指针next
 * 输入: 1->2->3->4->5 输出: 5->4->3->2->1
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //迭代方法
    public static ListNode iterate(ListNode head) {
        ListNode prev = null, curr, next;//定义前节点 当前  下一个
        curr = head;//当前节点等于head
        while (curr != null) {//循环到等于空节点就是到头部了
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = iterate(node1);
        ListNode nodeRecurs = recursion(node1);
        System.out.println(nodeRecurs);

        ListNode nodeShow=node;

        for(int i=0;i<5;i++){
            System.out.println(nodeShow.val);
            nodeShow=nodeShow.next;
        }

    }


}
