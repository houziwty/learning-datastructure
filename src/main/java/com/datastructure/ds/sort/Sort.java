package com.datastructure.ds.sort;

import com.google.inject.internal.cglib.proxy.$Enhancer;

import java.io.*;

/**
 * @author : tianyu.wang
 * create at:  2021/2/16  4:28 下午
 * @description:
 */
public class Sort {

    public static void main(String[] args) throws Exception {


        countMethon();


//        int[] arr = new int[]{99, 2, 1, 3, 5, 73, 90, 32, 12, 41, 65};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("arr:" + arr[i]);
//            System.out.print(",");
//        }
//        System.out.println();
//        System.out.println("===========");

//       bubbleSort(arr);
//        selctionSort(arr,arr.length);
//        sheelSort(arr, arr.length);
//        mergeSort(arr, 0, arr.length - 1);

//        shellSort(arr,arr.length);
//
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("arr:" + arr[i]);
//            System.out.print(",");
//        }

    }


    /***
     * @params
     * @return
     * @description :1冒泡排序
     * * 1、基本思想：
     *      两个数比大小，较大数下沉，较小数冒起来。
     *   2、过程：
     *      比较相邻的两个数据，如果第二个数小，就交换位置。
     *      从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，
     *      这样第一个最小数的位置就排好了。
     *      继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
     *   3、平均时间复杂度：O(n2)
     * @author tianyu.wang
     * @date 2021/2/16 4:29 下午
     */
    public static void bubbleSort(int[] arr) {
        int temp;//临时变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /***
     * @params []
     * @return void
     * @description: 2选择排序
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 。。。
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     * 平均时间复杂度：O(n2)
     * @author tianyu.wang
     * @date 2021/2/17 5:15 下午
     */
    public static void selctionSort(int array[], int length) {
        for (int i = 0; i < length - 1; i++) {
            int minIdex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIdex]) {
                    minIdex = j;
                }
            }
            if (minIdex != i) {
                int temp = array[i];
                array[i] = array[minIdex];
                array[minIdex] = temp;
            }
        }
    }

    /***
     * @params []
     * @return void
     * @description:
     * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     * 平均时间复杂度：O(n2)
     * @author tianyu.wang
     * @date 2021/2/22 2:54 下午
     */
    public static void insertionSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1;// 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                System.out.println("给insertVal 找到插入的位置:arr[insertIndex+1]" + arr[insertIndex + 1] + " arr[insertIndex]=" + arr[insertIndex]);
                arr[insertIndex + 1] = arr[insertIndex];

                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                System.out.println("给insertVal 找到插入的位置:arr[insertIndex+1]" + arr[insertIndex + 1] + " insertVal=" + insertVal);
                arr[insertIndex + 1] = insertVal;
            }
        }
    }


    /***
     * @params []
     * @return void
     * @description：4希尔排序
     * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。然后逐渐将增量减小,并重复上述过程。
     * 直至增量为1,此时数据序列基本有序,最后进行插入排序。
     * 时间复杂度:    O(n^（1.3—2）)
     * @author tianyu.wang
     * @date 2021/2/23 10:35 上午
     */
    public static void sheelSort(int array[], int length) {
        int temp = 0;
        int incre = length;
        while (true) {
            incre = incre / 2;
            for (int k = 0; k < incre; k++) {  //根据增量分为若干个子序列
                for (int i = k + incre; i < length; i += incre) {
                    for (int j = i; j > k; j -= incre) {
                        if (array[j] < array[j - incre]) {
                            System.out.println("比较:array[j-incre]" + array[j - incre] + " array[j]=" + array[j]);
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }

    }

    /***
     * @params []
     * @return void
     * @description :快速排序
     * 基本思想：（分治）
     * 先从数列中取出一个数作为key值；
     * 将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
     * 对左右两个小数列重复第二步，直至各区间只有1个数
     * 平均时间复杂度：O(N*logN)
     * @author tianyu.wang
     * @date 2021/2/23 2:29 下午
     */
    public static void quickSort(int array[], int left, int right) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        int key = array[left];//选择第一个数作为key
        while (i < j) {
            while (i < j && array[j] >= key) {//从右向左找到第一个小于key的值
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (i < j && array[i] < key) {//从左向右第一个大于key的值
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = key;
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

    }

    /***
     * @params []
     * @return void
     * @description:归并排序
     * 归并排序是建立在归并操作上的一种有效的排序算法。
     * 该算法是采用分治法的一个非常典型的应用。
     * 首先考虑下如何将2个有序数列合并。这个非常简单，
     * 只要从比较2个数列的第一个数，谁小就先取谁，
     * 取了后就在对应数列中删除这个数。然后再进行比较，
     * 如果有数列为空，那直接将另一个数列的数据依次取出即可。
     * O(NlogN)
     * @author tianyu.wang
     * @date 2021/3/1 11:12 上午
     */
    public static void mergeSort(int a[], int start, int end) {
        if (start < end) {
//            int middle=start+(end-start)/2;
            int middle = (start + end) / 2;
            mergeSort(a, start, middle); //左半部分排序
            mergeSort(a, middle + 1, end);
            merge(a, start, middle, end);
        }
    }

    //将有序数组a[] b[] 合并到c 中
    static void merge(int a[], int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;
        int left[] = new int[n1 + 1];
        int right[] = new int[n2 + 1];
        //复制两部分到新数组
        for (int i = 0; i < n1; i++) {
            left[i] = a[start + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[middle + j + 1];
        }

        left[n1] = Integer.MAX_VALUE;

        right[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        //循环判断数组的值并插入原来数组
        // 由于具有令牌 不需要考虑数组达到 末尾的情况
        for (int k = start; k <= end; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }
    }

    /***
     * @params [array, length]
     * @return void
     * @description:希尔排序
     * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。
     * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
     * 然后，取第二个增量d2<d1重复上述的分组和排序，
     * 直至所取的增量  =1(  <  …<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
     * 其实就是分成很多小组使序列尽可能的变成有序段，
     * 因为我们通过对插入排序分析可知，插入排序对已经排好序的序列速度是很快的。
     * 来看一个具体的过程：7 8 9 0 4 3 1 2 5 10
     * 我们取的这个增量分别就是5 2 1
     * O(n^(1.3—2))
     * @author tianyu.wang
     * @date 2021/3/4 10:41 上午
     */
    static void shellSort(int array [],int length){
        int temp=0;
        int incre=length;
        while(true){
            incre=incre/2;
            for(int k=0;k<incre;k++){
                for(int i =k+incre;i<length;i+=incre){
                    for(int j=i;j>k;j-=incre){
                        if(array[j]<array[j-incre]){
                            temp=array[j-incre];
                            array[j-incre]=array[j];
                            array[j]=temp;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(incre==1){
                break;
            }
        }
    }

    static void countMethon() throws Exception {
        String str = null;

        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        int data[] = new int[2100002];
        int i = 0;
        while ((str = br.readLine()) != null) {
            double a = Double.valueOf(str);
            a = a * 100;
            data[i++] = (int) a;
            // System.out.println((int) a);
        }
        System.out.println("读取数据size为" + i);
        long start = System.currentTimeMillis();
        countSort(data, 0, data.length - 1);
        System.out.println("快排消耗时间:" + (System.currentTimeMillis() - start) + "ms");
    }

    static  String fileName="/Users/tianyu.wang/Downloads/图书/算法/【数据结构与算法-赵云】/09/贪心算法&动态规划/200w.txt";

    static void countSort(int data[],int min ,int max)throws Exception{
        int counts[]=new int [max+1];
        for(int i=0;i<data.length;i++){
            counts[data[i]]++;
        }
        File file=new File(fileName);
        Writer out=new FileWriter(file);
        for(int i=0;i<=max;i++){
            if(counts[i]>0){
                for(int j=0;j<counts[i];j++){
                    out.write((double)(i/100.0)+"\r\n");
                }
            }
        }
        out.close();
    }


}
