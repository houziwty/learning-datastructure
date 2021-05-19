package com.datastructure.ds.array;

import com.google.inject.internal.asm.$AnnotationVisitor;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : tianyu.wang
 * create at:  2021/5/19  3:43 下午
 * @description: 最长连续序列
 */
public class FindLength {

    public static void main(String[] args) {
        int []nums={6,2,7,5,4,3,1};
        System.out.println(1 << 30);
        System.out.println(findLengthOfLCIS(nums));
    }
    //从0开始寻找递增序列，并将长度记录，记录递增序列的最后一个下标，然后从该下标继续寻找，记录 长度，取长度最大的即可
    static  int findLengthOfLCIS(int []nums){

        int result=0;
        int n=nums.length;
        int start=0;
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]<=nums[i-1]){
                start=i;
            }
            System.out.println("result:"+result+" start:"+start+ "i-start+1:"+(i-start+1));
            result=Math.max(result,i-start+1);
        }
        return result;
    }
}
