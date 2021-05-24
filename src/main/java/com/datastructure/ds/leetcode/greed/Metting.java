package com.datastructure.ds.leetcode.greed;


import java.util.ArrayList;
import java.util.List;

/**
 * @author : tianyu.wang
 * create at:  2021/3/4  2:59 下午
 * @description: 贪心算法
 * 贪心算法又叫做贪婪算法，它在求解某个问题是，总是做出眼前最大利益。
 * 也就是说只顾眼前不顾大局，所以它是局部最优解。核心点：通过局部最优推出全局最优。
 *
 */
public class Metting  implements Comparable<Metting>{

    public static void main(String[]args){
        List<Metting> mettingList=new ArrayList<>();
        int n=24;
        for(int i=0;i<n;i++){
            int start =i;
            int end=i+1;
            Metting metting = new Metting(i, start, end);
            mettingList.add(metting);
        }
        mettingList.sort(null);
        int curTime = 8;		//当前的时间,从一天的0点开始,如果领导要求从8点开始 那curTime=8
        for(int i=0;i<n;i++){
            Metting metting=mettingList.get(i);
            if(metting.startTime>=curTime){//会议的开始时间比我们当前的要大 表示可以开
                System.out.println(metting.toString());
                curTime = metting.endTime;
            }
        }

    }


    int meNum;//编号
    int startTime;//开始时间
    int endTime;//结束时间;

    public Metting(int meNum, int startTime, int endTime){
        super();
        this.meNum = meNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Metting o) {
        if(this.endTime>o.endTime)
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Metting [meNum=" + meNum + ", startTime=" + startTime
                + ", endTime=" + endTime + "]";
    }
}


