package com.datastructure.ds.tree;

/**
 * @author : tianyu.wang
 * create at:  2021/4/19  5:54 下午
 * @description:二查搜索树
 */
public class BinarySeachTree {
    private int color = 0;//0表示黑，1表示红

    int data;

    BinarySeachTree left;

    BinarySeachTree right;

    BinarySeachTree parent;

    public BinarySeachTree(int data) {
        this.data = data;
        this.left = null;
        this.parent = null;
        this.color = 1;
        this.right = null;
        //parent.parent	;爷爷
        //parent.parent.left 左边的叔叔
        //parent.left 兄弟姐妹
    }

    //插入的时候每次都是和根结点比较。一直要找到它应该插入的位置。
    //肯定会插在叶子结点。那么其实大家可以看到 插入其实就是查找。 默认root不会为空

     void insert(BinarySeachTree root, int data) {
        //if(root == null) {}
        if (root.data < data) {//根节点小 我们要放到右边
            if (root.right == null) {
                root.right = new BinarySeachTree(data);
            } else {
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new BinarySeachTree(data);
            } else {
                insert(root.left, data);
            }
        }
    }

      void find(BinarySeachTree root, int data) {
        if (root != null) {
            if (root.data < data) {
                find(root.right, data);
            } else if (root.data > data) {
                find(root.left, data);
            }else {
                System.out.println("找到了");
                System.out.println(root.data);
                return ;
            }
        }
    }
     void pre(){//前序遍历 根(输出) 左 右

    }
      void post(){//后序遍历  左  右 根(输出)

    }
      void in(BinarySeachTree root){//中序遍历  左 根(输出)  右
        if(root!=null){
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }

    }
}
