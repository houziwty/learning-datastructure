package com.datastructure.ds.leetcode.greed;

/**
 * @author : tianyu.wang
 * create at:  2021/3/5  2:28 下午
 * @description:贪心
 * 假设纸币金额为1元、5元、10元、20元、50元、100元，123元应该尽可能兑换少的纸币。
 * 按尝试应该兑换1张100、1张20元和3张1元的。
 */
public class Money {
    public static  void  main(String []args){
        splitChange(123);
    }
    static void splitChange(int money){
        int[] prices = {100, 50, 20, 10, 5, 1};
        int [] notes=new int[prices.length];
        int change=money;
        if(money>0){
            while (change>0){
                for(int i=0;i<prices.length;i++){
                    int count=0;
                    for(int k=0;change-prices[i]>=0;k++){
                        //判断是否相减后等于负数
                        if(change-prices[i]>=0){
                            //重新赋值 为下一轮计算
                            change=change-prices[i];
                            count++;
                        }else break;
                    }
                    notes[i]=count;
                }
            }
        }
        System.out.println("找零:");
        for(int num=0;num<prices.length;num++){
            System.out.print(notes[num] + "张" + prices[num] + "元  ");
        }
    }
}
