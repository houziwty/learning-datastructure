package com.datastructure;

/**
 * @author : tianyu.wang
 * create at:  2021/5/10  4:55 下午
 * @description:斐波那契数列
 * 求取斐波那契数列第N位的值。 斐波那契数列:每一位的值等于他前两位数字之和。前两位固定 0，1,1,2,3,5,8。。。。
 */
public class Fibonacci {
    public static void main(String []args){
        System.out.println(calculate(4));
    }

    //解法一:暴力递归
    static int calculate(int num){
        if(num==0)
            return 0;
        if(num==1)
            return 1;
        return calculate(num-1)+calculate(num-2);

    }
}
