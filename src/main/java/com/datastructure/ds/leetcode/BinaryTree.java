package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/4/14  4:10 下午
 * @description:
 */
public class BinaryTree {

    public static void main(String[] args) {
        MyTreeNode D = new MyTreeNode('D', null, null);
        MyTreeNode H = new MyTreeNode('H', null, null);
        MyTreeNode K = new MyTreeNode('K', null, null);
        MyTreeNode C = new MyTreeNode('C', D, null);
        MyTreeNode G = new MyTreeNode('G', H, K);
        MyTreeNode B = new MyTreeNode('B', null, C);
        MyTreeNode F = new MyTreeNode('F', G, null);
        MyTreeNode E = new MyTreeNode('E', null, F);
        MyTreeNode A = new MyTreeNode('A', B, E);


        System.out.println("前");
        pre(A);
        System.out.println();
        System.out.println("中");
        in(A);
        System.out.println();
        System.out.println("后");
        post(A);

    }


    public static void print(MyTreeNode node) {
        System.out.print(node.getData());
    }


    public static void pre(MyTreeNode root) {//前序遍历 根(输出) 左 右 时间复杂度？O(n) N^2 O(2*n)=>O(n);
        print(root);
        if (root.getLeft() != null) {
            pre(root.getLeft());//认为是子树,分解子问题；
        }
        if (root.getRight() != null) {
            pre(root.getRight());
        }
    }

    static void in(MyTreeNode root) {//中序遍历  左 根(输出)  右
        if (root.getLeft() != null) {
            in(root.getLeft());//认为是子树,分解子问题；
        }
        print(root);
        if (root.getRight() != null) {
            in(root.getRight());
        }
    }

    static void post(MyTreeNode root) {//后序遍历  左  右 根(输出)
        if (root.getLeft() != null) {
            post(root.getLeft());
        }
        if (root.getRight() != null) {
            post(root.getRight());
        }
        print(root);
    }


    static class MyTreeNode {
        private MyTreeNode left;
        private MyTreeNode right;

        public MyTreeNode(char data, MyTreeNode left, MyTreeNode right) {
            super();
            this.setData(data);
            this.setLeft(left);
            this.setRight(right);
        }


        private char data;

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public MyTreeNode getLeft() {
            return left;
        }

        public void setLeft(MyTreeNode left) {
            this.left = left;
        }

        public MyTreeNode getRight() {
            return right;
        }

        public void setRight(MyTreeNode right) {
            this.right = right;
        }


    }
}
