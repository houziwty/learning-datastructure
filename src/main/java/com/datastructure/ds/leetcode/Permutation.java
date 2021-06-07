package com.datastructure.ds.leetcode;


import com.google.inject.internal.cglib.core.$DefaultGeneratorStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : tianyu.wang
 * create at:  2021/6/7  9:30 上午
 * @description: 字符串排列
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")) );
    }

    static List<String> res = new LinkedList<>();

    static char[] c;

    static String[] permutation(String s) {
        c = s.toCharArray();
        System.out.println("c:"+Arrays.toString(c));
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    static void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));// 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;// 重复，因此剪枝
            System.out.println("c[i]:"+c[i]);
            set.add(c[i]);
            swap(i, x);// 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);// 开启固定第 x + 1 位字符
            swap(i, x);// 恢复交换
        }

    }

    static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
