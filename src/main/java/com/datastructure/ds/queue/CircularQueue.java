package com.datastructure.ds.queue;

/**
 * @author : tianyu.wang
 * create at:  2021/5/7  11:19 上午
 * @description: 环形队列
 */
public class CircularQueue {
    int[] data;
    int head, tail;

    CircularQueue(int cap) {
        data = new int[cap + 1];
        head = 0;
        tail = 0;
    }

    boolean enQueue(int value) {
        if (isFull()) {//如果入队尾部等于头部证明 到环形头部
            return false;
        } else {
            data[tail] = value;
            tail = (tail + 1) % data.length;//排序,树形结构 //循环队列 tail=7 8越界了，(7+1)%8==0 赋值最后环形
            return true;
        }
    }

    boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % data.length;//头部向前走一步
            return true;
        }
    }


    int front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    int rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(tail - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    boolean isFull() {
        return (tail + 1) % data.length == head; //如果入队尾部等于头部证明 到环形头部
    }
}
