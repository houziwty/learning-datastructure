package com.datastructure.ds.greed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : tianyu.wang
 * create at:  2021/3/5  3:57 下午
 * @description:多机调度问题 设有n个独立的作业{1, 2, …, n}, 由m台相同的机器进行加工处理. 作业i所需时间为ti。
 * 约定:任何作业可以在任何一台机器上加工处理, 但未完工前不允许中断处理,任何作业不能拆分成更小的子作业。
 * 要求给出一种作业调度方案，使所给的 n 个作业在尽可能短的时间内由 m 台机器加工处理完成。
 * 多机调度问题是一个 NP 完全问题，到目前为止还没有完全有效的解法。
 * 对于这类问题，用贪心选择策略有时可以设计出一个比较好的近似算法。
 * 采用最长处理时间作业优先的贪心策略:
 * 当n≤m时, 只要将机器i的[0, ti]时间区间分配给作业i即可。
 * 当n>m时, 将n个作业依其所需的处理时间从大到小排序,然后依次将作业分配给空闲的处理机。
 */
public class Job {

    public static void main(String []args){
        //多机调度问题
        int[] a = {5,4,2,14,16,6,5,3};
        int m = 3;
        System.out.println("总时间为："+greedy(a,m));

    }

    static int greedy(int []a,int m){
        //int n = a.length - 1;//a的下标从1开始，所以n（作业的数目）=a.length-1
        int  n=a.length;
        int sum=0;
        if(n<=m){
            for(int i=0;i<n;i++){
               sum+=a[i+1];
                System.out.println("为每个作业分别分配一台机器");
                return sum;
            }
        }
        List<JobNode>d=new ArrayList<>();//d保存所有的作业
        for(int i=0;i<n;i++){//将所有的作业存入List中，每一项包含标号和时间
            JobNode jb=new JobNode(i+1,a[i]);
            d.add(jb);
        }
        Collections.sort(d);//对作业的List进行排序
        LinkedList<MachineNode>h=new LinkedList<>();//h保存所有的机器
        for(int i=0;i<m;i++){
            MachineNode x=new MachineNode(i+1,0);
            h.add(x);
        }
        for(int i=0;i<n;i++){
            Collections.sort(h);
            MachineNode x=h.peek();
            System.out.println("机器"+x.id+"从"+"到"+(x.avail+d.get(i).time)+"的时间段分配作业 机器号"+d.get(i).id);
            x.avail+=d.get(i).time;
            sum=x.avail;
        }
        return sum;
    }

    public static class JobNode implements Comparable<JobNode> {//按时间从大到小排列
        int id;//作业的标号
        int time;//作业时间

        public JobNode(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(JobNode o) {
            int times = o.time;
            return Integer.compare(times, time);
        }
    }
    public static class MachineNode implements Comparable<MachineNode>{
        int id;//机器号
        int avail;//机器空闲的时间（即机器做完某一项工作的时间）

        public MachineNode(int id,int avail){
            this.id=id;
            this.avail=avail;
        }

        @Override
        public int compareTo(MachineNode o) {//升序排序，LinkedList的first为最小的
            int xs=o.avail;
            return Integer.compare(avail,xs);
        }
    }

}
