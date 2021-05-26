package com.datastructure.ds;

/**
 * @author : tianyu.wang
 * create at:  2021/5/26  10:50 上午
 * @description:翻转二叉树
 */
public class ReveBinerTree {
    public  static void main(String []args){
        TreeNode node=new TreeNode(4);
        node.left=new TreeNode(2);
        node.right=new TreeNode(7);
        invertTree(node);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);


    }


    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    static  int  invertTree(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.left!=null){
            invertTree(node.left);
        }
        if(node.right!=null){
            invertTree(node.right);
        }
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        return node.val;

    }
}
