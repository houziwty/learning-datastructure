package com.datastructure.ds.array;

/**
 * @author : tianyu.wang
 * create at:  2021/5/14  5:04 下午
 * @description:排列硬币 总共有 n 枚硬币，将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内
 */
public class CoinsSort {

    public static void main(String[] args) {



        System.out.println(arrangeConins(100));
        System.out.println(arrangeConins2(100));

        System.out.println(sqrts(100, 100));

    }

    //    解法一:迭代
//    从第一行开始排列，排完一列、计算剩余硬币数，排第二列，直至剩余硬币数小于或等于行数
    static int arrangeConins(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }

    //    解法二:二分查找
//    假设能排 n 行，计算 n 行需要多少硬币数，如果大于 n，则排 n/2行，再计算硬币数和 n 的大小关系
    static int arrangeConins2(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid=(high+low)/2;
            int cost=((mid+1)*mid)/2;
            if(cost==n){
                return mid;
            }else if(cost>n){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return high;
    }

    //    解法三:牛顿迭代
//    使用牛顿迭代求平方根，(x + n/x)/2
//    假设能排 x 行 则 1 + 2 + 3 + ...+ x = n，即 x(x+1)/2 = n 推导出 x = 2n - x
    static double sqrts(double x, int n) {
        double res = (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res, n);
        }
    }

}
