package com.datastructure.ds.leetcode.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : tianyu.wang
 * create at:  2021/3/9  2:15 下午
 * @description:
 * 问题描述：
 * 有n门课，号码从1到n。每门课有对应的时长t以及截至日期d。选择了一门课，就得持续t天并且在d之前完成这门课。从第一天开始。
 * 给定n门课程，以(t, d)对表示，你需要找出你可以参加的最多的课程数。
 * 需要注意，你不能同时上两门课。
 *
 * 问题分析:
 *
 * 贪心法
 * 先对数组以d排序，在遍历数组的过程中维护当前日期，
 * 若课程可选，那么增加当前日期，若不可选，
 * 从已经选过的课程中找出一个耗时最长的课程，若该课程耗时比当前课程长，那么替换。重复此过程
 */
public class Course {
    public static void main(String[]args){
        //课程表
        int[][] course = {{2,5},{2,19},{1,8},{1,3}};
        System.out.println(scheduleCourse(course));
    }


     static int scheduleCourse(int [][]courses){
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                System.out.println(o1[1] +"  "+o2[1]);
                return o1[1] - o2[1];
            }
        });
        int count =0,curtime=0;
        for(int i=0;i<courses.length;i++){
            //若可选，增加当前时间，并且将当前课程放入courses中
            //否则，从courses中选一个耗时最长的课程，若这个耗时最长的课程比当前课程还长，则替换
            if(curtime+courses[i][0]<=courses[i][1]){
               courses[count++]=courses[i];
               curtime+=courses[i][0];
                System.out.println("curtime:"+curtime+" courses"+courses[i][0]);

            }else {
                int max_i=i;
                for(int j=count-1;j>=0;j--){
                    if(courses[j][0]>courses[max_i][0])
                        max_i=j;
                }
                if(courses[max_i][0]>courses[i][0]){
                    curtime+=courses[i][0]-courses[max_i][0];
                    courses[max_i]=courses[i];
                }
            }
        }
        return count;
    }

}
