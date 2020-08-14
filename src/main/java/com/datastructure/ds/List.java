package com.datastructure.ds;

public interface List<E>{

    //返回线性表的大小
    public int getSize();

    //判断线性表中是否为空
    public boolean isEmpty();

    //判断线性表中是否包含元素o
    public boolean contains(E o);


}
