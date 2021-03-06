package com.datastructure.ds.array;

import com.datastructure.ds.list.List;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayList<E> implements List<E> {
    public  static void main(String []args){



        List<Integer>list=new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(i,i);
        }
        for(int i=0; i<100; i++) {
            System.out.println("The " + i + "th element is: " + list.get(i));
        }

        for(int i=0; i<50; i+=8) {
            list.remove(i);
        }

        for(int i=0; i<list.getSize(); i++) {
            System.out.println("After removing, the " + i + "th element is: " + list.get(i));
        }

        System.out.println(5&1);
        System.out.println((3&2)==0);
    }

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size;

    public ArrayList(int capacity) {
        this.size = 0;
        data = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //O(n)
    @Override
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //O(1)
    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("数组小标越界...");
        return data[index];
    }

    //O(1)
    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("数组小标越界...");
        data[index] = e;
    }

    //O(n)
    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组小标越界...");
        }
        if (size == data.length) {
            grow(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(E e){
        add(size,e);
    }

    @Override
    public E remove(int index) {
        if(index<0||index>=size){
            throw  new IllegalArgumentException("数组小标越界...");
        }
        E val=data[index];
        for(int i= index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        if(size<(data.length>>1)){
            grow(data.length/2);
        }
        return val;
    }

    private void grow(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }
}
