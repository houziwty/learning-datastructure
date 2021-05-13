package com.datastructure.ds.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : tianyu.wang
 * create at:  2021/5/12  4:05 下午
 * @description: 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达该节点，则链表中存在环 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class CycleLinkList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next= node1;


//        ListNode nodeShow = node1;
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(nodeShow.val);
//            nodeShow = nodeShow.next;
//        }
        System.out.println(hasCycle(node5));

        System.out.println(hasCycle2(node5));

    }

    //解法一:哈希表
    static boolean hasCycle(ListNode head) {
        Set<ListNode>seen=new HashSet<>();
        while (head!=null){
            System.out.println(head.val);
            //循环到重复节点
            if(!seen.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }

    //解法二:双指针
    static boolean hasCycle2(ListNode head){
        if(head==null||head.next==null){
            return  false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        return true;
    }
}
