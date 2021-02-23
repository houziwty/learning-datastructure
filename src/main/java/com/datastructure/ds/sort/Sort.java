package com.datastructure.ds.sort;

/**
 * @author : tianyu.wang
 * create at:  2021/2/16  4:28 下午
 * @description:
 */
public class Sort {

    public static void main(String []args){
       int []arr=new int[]{99,2,1,3,5,73,90,32,12,41,65};
        for(int i=0;i<arr.length;i++){
            System.out.print("arr:"+arr[i]);
            System.out.print(",");
        }
        System.out.println();
        System.out.println("===========");

//       bubbleSort(arr);
//        selctionSort(arr,arr.length);
        sheelSort(arr,arr.length);
       for(int i=0;i<arr.length;i++){
           System.out.print("arr:"+arr[i]);
           System.out.print(",");
       }

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
    public static void bubbleSort(int []arr){
        int temp;//临时变量
        for(int i=0;i<arr.length-1;i++){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
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
    public static void selctionSort(int array[],int length){
        for(int i=0;i<length-1;i++){
            int minIdex=i;
            for(int j=i+1;j<length;j++){
                if(array[j]<array[minIdex]){
                    minIdex=j;
                }
            }
            if(minIdex!=i){
                int temp=array[i];
                array[i]=array[minIdex];
                array[minIdex]=temp;
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
    public static void insertionSort(int []arr){
        int insertVal=0;
        int insertIndex=0;
        for(int i=1;i<arr.length;i++){
            //定义待插入的数
            insertVal=arr[i];
            insertIndex=i-1;// 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while(insertIndex>=0&&insertVal<arr[insertIndex]){
                System.out.println("给insertVal 找到插入的位置:arr[insertIndex+1]"+arr[insertIndex+1]+" arr[insertIndex]="+arr[insertIndex]);
                arr[insertIndex+1]=arr[insertIndex];

                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            //这里我们判断是否需要赋值
            if(insertIndex+1!=i){
                System.out.println("给insertVal 找到插入的位置:arr[insertIndex+1]"+arr[insertIndex+1]+" insertVal="+insertVal);
                arr[insertIndex+1]=insertVal;
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
    public static void sheelSort(int array[],int length ){
        int temp=0;
        int incre=length;
        while(true){
            incre=incre/2;
            for(int k=0;k<incre;k++){  //根据增量分为若干个子序列
                for(int i=k+incre;i<length;i+=incre){
                    for(int j=i;j>k;j-=incre){
                        if(array[j]<array[j-incre]){
                            System.out.println("比较:array[j-incre]"+array[j-incre]+" array[j]="+array[j]);
                            temp=array[j-incre];
                            array[j-incre]=array[j];
                            array[j]=temp;
                        }else {
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

}
