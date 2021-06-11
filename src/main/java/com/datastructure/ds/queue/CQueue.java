package com.datastructure.ds.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : tianyu.wang
 * create at:  2021/6/10  下午3:09
 * @description: 双栈实现队列
 * 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
 *
 * 根据栈先进后出的特性，我们每次往第一个栈里插入元素后，
 * 第一个栈的底部元素是最后插入的元素，
 * 第一个栈的顶部元素是下一个待删除的元素。为了维护队列先进先出的特性，
 * 我们引入第二个栈，
 * 用第二个栈维护待删除的元素，
 * 在执行删除操作的时候我们首先看下第二个栈是否为空。
 * 如果为空，我们将第一个栈里的元素一个个弹出插入到第二个栈里，
 * 这样第二个栈里元素的顺序就是待删除的元素的顺序，
 * 要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。
 *
 * 成员变量
 *
 * 维护两个栈 stack1 和 stack2，其中 stack1 支持插入操作，
 * stack2 支持删除操作
 * 构造方法
 *
 * 初始化 stack1 和 stack2 为空
 * 插入元素
 *
 * 插入元素对应方法 appendTail
 *
 * stack1 直接插入元素
 * 删除元素
 *
 * 删除元素对应方法 deleteHead
 *
 * 如果 stack2 为空，则将 stack1 里的所有元素弹出插入到 stack2 里
 * 如果 stack2 仍为空，则返回 -1，否则从 stack2 弹出一个元素并返回
 *
时间复杂度：对于插入和删除操作，时间复杂度均为 O(1)O(1)。
插入不多说，对于删除操作，虽然看起来是 O(n)O(n) 的时间复杂度，
但是仔细考虑下每个元素只会「至多被插入和弹出 stack2 一次」，
因此均摊下来每个元素被删除的时间复杂度仍为 O(1)O(1)。

空间复杂度：O(n)O(n)。需要使用两个栈存储已有的元素。
 */
public class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    //加入队尾
    public void appendTail(int value) {
        stack1.push(value);
    }

    //删除头部
    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }


}
