package com.datastructure.ds.sort;

import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/5/17  11:54 上午
 * @description: 快排
 */
public class QuiklySort {
    public static void main(String[] args) {
        int data[] = {9, 5, 2, 8, 0, 1, 3, 6, 7};

        quiklySort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    static void quiklySort(int data[], int left, int right) {
        int base = data[left];// 就是我们的基准数，取序列的第一个,不能用data[0]
        int l = left;// 表示的是从左边找的位置
        int r = right;// 表示从右边开始找的位置
        while (l < r) {
            // 从后面往前找比基准数小的数
            while (l < r && data[r] >= base) {//从右向左找到第一个小于key的值
                r--;
            }
            if (l < r) {// 表示是找到有比之大的
                int temp = data[r];
                data[r] = data[l];
                data[l]=temp;
                l++;
            }
            while (l<r&&data[l]<=base){
                l++;
            }
            while (l<r){
                int temp=data[r];
                data[r]=data[l];
                data[l]=temp;
                r--;
            }
        }
        // 肯定是递归 分成了三部分,左右继续快排，注意要加条件不然递归就栈溢出了
        if(left<l){
            quiklySort(data,left,l-1);
        }
        if(l<r){
            quiklySort(data,l+1,right);
        }

    }
}
