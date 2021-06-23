package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/20  下午2:15
 * @description:
 */
public class Feishu {


    class Node {
        int val;
        Node next;

    }

    class SetArrays {
        Node node;

        //
        boolean insert(int val) {
            boolean ischekout = false;
            if (node == null) {
                node = new Node();
                node.val = val;
                ischekout = true;
            } else {
                while (true) {
                    if (node.val == val) {
                        break;
                    }
                    if (node.next == null) {
                        ischekout = true;
                        break;
                    }
//                    if (node.next.val != val) {
//                        ischekout = true;
//                        break;
//                    }
                   node= node.next;

                }
                if (ischekout) {
                    node.next.val = val;
                    node.next = this.node;
                }

            }
            return ischekout;
        }

        SetArrays mergeList(SetArrays setNode) {
            SetArrays newNode = new SetArrays();
            Node pre = newNode.node;
            while (this.node != null && setNode != null) {
                if (this.node.val <= setNode.node.val) {
                    pre.next = this.node;
                    this.node = this.node.next;
                } else {
                    pre.next = setNode.node;
                    setNode.node = setNode.node.next;
                }
                pre = pre.next;
            }
            pre.next = this.node == null ? setNode.node : this.node;

            return newNode;
        }

    }

}
