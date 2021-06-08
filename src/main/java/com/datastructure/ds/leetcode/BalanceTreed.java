package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/7  下午8:21
 * @description: 平衡二叉树
 * 自顶向下的递归
 * 有了计算节点高度的函数，即可判断二叉树是否平衡。
 * 具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点，
 * 首先计算左右子树的高度，如果左右子树的高度差是否不超过 1，
 * 再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。这是一个自顶向下的递归的过程
 */
public class BalanceTreed {
    public static void main(String[] args) {

    }

   static boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }else {
            return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }

    }

    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
