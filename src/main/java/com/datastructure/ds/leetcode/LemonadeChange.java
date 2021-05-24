package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/5/20  9:38 上午
 * @description:
 */
public class LemonadeChange {

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(nums));
    }

    //我们维护两个变量 five 和 ten 表示当前手中拥有的 5 美元和 10 美元钞票的张数，从前往后遍历数组分类讨论即可。
   static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five > 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
