package com.datastructure.ds;

/**
 * @author : tianyu.wang
 * create at:  2021/5/6  2:09 下午
 * @description: x平方根
 * 在不使用 sqrt(x) 函数的情况下，得到 x的平方根的整数部分 解法一:二分查找
 * x的平方根肯定在0到x之间，使用二分查找定位该数字，该数字的平方一定是最接近x的，m平方值如果 大于x、则往左边找，如果小于等于x则往右边找
 * 找到0和X的最中间的数m，
 * 如果m * m > x，则m取x/2到x的中间数字，直到m * m < x，m则为平方根的整数部分
 * 如果m * m <= x，则取0到x/2的中间值，知道两边的界限重合，找到最大的整数，则为x平方根的整数 部分
 * 时间复杂度:O(logN)
 */
public class Sqrt {
}
