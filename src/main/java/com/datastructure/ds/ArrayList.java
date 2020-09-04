package com.datastructure.ds;

public class ArrayList<E> implements  List<E> {

    private static final int DEFAULT_CAPACITY=10;

    private E[]data;
    private int size;

    public ArrayList(int capacity){
        this.size=0;
        data= (E[]) new Object[capacity];
    }

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(E o) {
        for(int i=0; i<size;i++){
            if(data[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if(index<0||index>=size)
            throw new IllegalArgumentException("数组小标越界");
        return data[index];
    }

    @Override
    public void set(int index, E e) {

    }

    @Override
    public void add(int index, E e) {

    }

    @Override
    public E remove(int index) {
        return null;
    }
}
