package com.datastructure.ds.tree;

/**
 * @author : tianyu.wang
 * create at:  2021/4/14  4:10 下午
 * @description:
 */
public class BinaryTree {
    class  MyTreeNode{
        private MyTreeNode left;
        private MyTreeNode right;
        public  MyTreeNode(char data,MyTreeNode left,MyTreeNode right){
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
