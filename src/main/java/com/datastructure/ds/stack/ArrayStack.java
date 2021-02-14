package com.datastructure.ds.stack;

import org.omg.CORBA.Object;

import java.util.Objects;

/**
 * @author : tianyu.wang
 * create at:  2021/1/26  2:40 下午
 * @description:
 */
public class ArrayStack<Item> implements Stack<Item> {

    //最好就是开始的时候就设置大小
    private Item[]a= (Item[]) new Objects[1];

    //大小 初始的元素个数
    private int n=0;

    public ArrayStack(int cap){
        a= (Item[]) new Object[cap];
    }

    public ArrayStack() {

    }

    @Override
    public Stack<Item> push(Item item) {//入栈就完成了		//时间复杂度 O(1)
        judgeSize();
        a[n++]=item;
        return null;
    }
    private void judgeSize(){
        if(n>=a.length){//元素个数已经超出了数组的个数
            resize(2*a.length);//10*2*2=40个大小了，我出栈了20个了，只剩下20了吧。
        }else if(n>0&&n<=a.length/2){
            resize(a.length/2);
        }
    }

    private void resize(int size){//扩容O（n）
        Item[]temp= (Item[]) new Object[size];
        for(int i=0;i<n;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    @Override
    public Item pop() {//出栈 O(1)
        if(isEmpty()){
            return null;
        }
        Item item=a[--n];//n不是已经--了么 --n和n-- --n是先把n减了在用，n--先用了在减
        a[n]=null;
        return item;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Item peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }
}
