package com.datastructure.ds.array;



public class ClimbStairs  {

    public static void main(String[] args) {
      System.out.println(climbStairs(5));
    }

   static int climbStairs(int n){
        int p=0,q=0,r=1;
        for(int i=1;i<=n;++i){
            p=q;
            q=r;
            r=p+q;
            System.out.println("p:"+p+" q:"+q+" r:"+r );
        }
        return r;
    }


}
