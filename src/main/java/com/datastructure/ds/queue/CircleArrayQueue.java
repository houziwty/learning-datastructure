package com.datastructure.ds.queue;

/**
 * @author : tianyu.wang
 * create at:  2021/2/26  10:12 上午
 * @description:
 */
public class CircleArrayQueue {
    int data[];// 数据
    int head=0;//头
    int tail=0;//尾
    int n=0;//数组的大小 最大的空间
    int size ;//当前已经存了几个数了

    public CircleArrayQueue(int cap){
        data=new int[cap];
        n=cap;
    }

    public void push(int value){//入队列  O(1)		//排序
//        if(isFull()) 或
        if((tail+1)%n==head){ //如果入队尾部等于头部证明 到环形头部
            return;
        }

        data[tail]=value;// 1 2 3 4 5 	排序,树形结构
        tail = (tail + 1) % n;		//循环队列 tail=7 8越界了，(7+1)%8==0
    }

    public int pop(){//出队列 1 2 3 4 5 O(1) 很大的空间浪费
        if(isEmpty())return -1;
        int m=data[head];
        head=(head+1)%n; //头部向前走一步
        return m;
    }

    public boolean isEmpty(){
        if(head==tail)return true;
        return false;
    }

    boolean isFull(){
        return (tail + 1) % data.length == head;
    }
}
