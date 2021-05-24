package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/4/19  5:54 下午
 * @description:二查搜索树
 */
public class BinarySeachTree {
    private int color = 0;//0表示黑，1表示红

    int data;

    BinarySeachTree left;

    BinarySeachTree right;

    BinarySeachTree parent;

    public BinarySeachTree(int data) {
        this.data = data;
        this.left = null;
        this.parent = null;
        this.color = 1;
        this.right = null;
        //parent.parent	;爷爷
        //parent.parent.left 左边的叔叔
        //parent.left 兄弟姐妹
    }

    //插入的时候每次都是和根结点比较。一直要找到它应该插入的位置。
    //肯定会插在叶子结点。那么其实大家可以看到 插入其实就是查找。 默认root不会为空

    void insert(BinarySeachTree root, int data) {
        //if(root == null) {}
        if (root.data < data) {//根节点小 我们要放到右边
            if (root.right == null) {
                root.right = new BinarySeachTree(data);
            } else {
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new BinarySeachTree(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    void find(BinarySeachTree root, int data) {
        if (root != null) {
            if (root.data < data) {
                find(root.right, data);
            } else if (root.data > data) {
                find(root.left, data);
            } else {
                System.out.println("找到了");
                System.out.println(root.data);
                return;
            }
        }
    }

    void pre(BinarySeachTree root) {//前序遍历 根(输出) 左 右
        if (root != null) {
            System.out.println(root.data);
            pre(root.left);
            pre(root.right);
        }

    }

    void post(BinarySeachTree root) {//后序遍历  左  右 根(输出)

    }

    void in(BinarySeachTree root) {//中序遍历  左 根(输出)  右
        if (root != null) {
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }
    }

    public static void main(String[] args) {
        //快速排序，归并排序，二叉树排序
        int data[] = {0, 5, 9, 1, 2, 3, 10};
        BinarySeachTree root = new BinarySeachTree(data[0]);//第一个点作为跟结点
        for (int i = 1; i < data.length; i++) {
            root.insert(root, data[i]);
        }
        System.out.println("中序遍历:");
        root.in(root);
    }

    /**
     * @author : tianyu.wang
     * create at:  2021/5/18  12:02 下午
     * @description:字符串相加
     */
    public static class AddString {
        public static void main(String []args){
    System.out.println(addString("123","37"));
        }
        static  String addString(String num1,String num2){
          int i=num1.length()-1,j=num2.length()-1,add=0;
        StringBuilder ans=new StringBuilder();
        while (i>=0||j>=0||add!=0){

            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int result=x+y+add;
            ans.append(result%10);
            add=result/10;


            i--;
            j--;
        }
        ans.reverse();
        return  ans.toString();
        }
    }

    /**
     * @author : tianyu.wang
     * create at:  2021/3/3  10:11 上午
     * @description:
     */
    public static class Fibonacci {
        public static void main(String []args){
    //        for (int i = 1; i <= 45; i++) {
    //            long start = System.currentTimeMillis();
    //            System.out.println(i + ":" + tailfab(1,1,i) + " 所花费的时间为"
    //                    + (System.currentTimeMillis() - start) + "ms");
    //        }
            //tailFac(5, 1));

            /*
             * for (int i = 1; i <= 45; i++) { long start =
             * System.currentTimeMillis(); System.out.println(i + ":" + fab(i) +
             * " 所花费的时间为" + (System.currentTimeMillis() - start) + "ms"); }
             */

            /*for (int i = 1; i <= 45; i++) {
                long start = System.currentTimeMillis();
                System.out.println(i + ":" + noFab(i) + " 所花费的时间为"
                        + (System.currentTimeMillis() - start) + "ms");
            }
            System.out.println("==================================");
            System.out.println("加了缓存的情况");
            for (int i = 1; i <= 45; i++) {
                data = new int[46];
                long start = System.currentTimeMillis();
                System.out.println(i + ":" + fab2(i) + " 所花费的时间为"
                        + (System.currentTimeMillis() - start) + "ms");
            }*/
        }
        private static int data[];// 初始换全部是0

        // 1 1 2 3 5 8 13
        // f(n)=f(n-1)+f(n-2)
        public static int fab(int n){// 分析一段代码好坏，有两个指标，时间复杂度和空间复杂度 都是：O(2^n)
            if(n<=2)
                return 1;// 递归的终止条件
            return fab(n-1)+fab(n-2);//继续递归的过程
        }

        public static int fac(int n){// 求N的阶乘 用普通递归怎么写 5=5*4*3*2*1=> f(n) =
            if(n<=1)
                return 1;
            return n*fac(n-1);
        }
        public static int noFab(int n){// 不用递归 O(n)
            //循环
            if(n<=2)
                return 1;
            int a=1;
            int b=1;
            int c=0;
            for(int i=3;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }
        public static int fab2(int n){// 用数组来做缓存 将为了O(n)，空间也降至为O(n)
            if(n<=2)
                return 1;
            if(data[n]>0){
                return data[n];
            }
            int res=fab2(n-1)+fab2(n-2);// 继续递归的过程
            data[n]=res;
            return res;
        }
        /**
         * n 是肯定有的
         * res 上一次运算出来结果
         * pre 上上一次运算出来的结果
         */
        public static int tailfab(int pre,int res,int n){
            if(n<=2)
                return res;// 递归的终止条件
            return tailfab(res,pre+res,n-1);//JDK源码
        }
        public static int tailFac(int n ,int res){// 尾递归 传结果，res就是我们每次保存的结果
            System.out.println(n + ":" + res);	// 这个地方打印出来的值是怎么样的？
            if (n <= 1)
                return res;
            return tailFac(n - 1, n * res);	//倒着算
        }

    }

    /**
     * @author : tianyu.wang
     * create at:  2021/5/1  11:23 下午
     * @description:判断素数出现次数
     */
    public static class Primes {
        public static void main(String[] args) {
            System.out.println(countPrimes(100));

            System.out.println(eratosthenes(100));

        }

        /***
         * @params [n]
         * @return int
         * @description :直接从2开始遍历，判断是否能被2到自身之间的数整除
         * @author tianyu.wang
         * @date 2021/5/1 11:40 下午
         */
        public static int countPrimes(int n) {
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                ans += isPrimes(i) ? 1 : 0;
            }
            return ans;
        }

        //i如果能被x整除，则x/i肯定能被x整除，因此只需判断i和根号x之中较小的即可
        private static boolean isPrimes(int x) {
            for (int i = 2; i * i <= x; ++i) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }

        /***
         * @params [n]
         * @return int
         * @description :埃氏筛 利用合数的概念(非素数)，素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记
         * 利用合数的概念(非素数)，素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记
         * 将合数标记为true，j = i * i 从 2 * i 优化而来，
         * 系数2会随着遍历递增(j += i，相当于递增了系数2)，
         * 每一个合数都会有两个比本身要小的因子(0,1除外)，2 * i 必然会遍历到这两个因子
         * 当2递增到大于根号n时，其实后面的已经无需再判断(或者只需判断后面一段)，
         * 而2到根号n、实际 上在 i 递增的过程中已经计算过了，i 实际上就相当于根号n
         * 例如:n = 25 会计算以下
         * 2* 4=8
         * 3 * 4 = 12
         * 但实际上8和12已经标记过，在n = 17时已经计算了 3 * 4，2 * 4
         * @author tianyu.wang
         * @date 2021/5/1 11:56 下午
         */
        public static int eratosthenes(int n) {
            boolean[] isPrimes = new boolean[n];
            int ans = 0;
            for (int i = 2; i < n; i++) {
                if (!isPrimes[i]) {
                    ans += 1;
                    //将合数标记为true，j = i * i 从 2 * i 优化而来
                    for (int j = i * i; j < n; j += i) {
                        System.out.println("ans:"+ans+"  i:"+i+"*i:"+i+"="+(i*i)+" j:"+j +" j+n="+(j+i));
                        isPrimes[j] = true;
                    }
                }
            }

            return ans;
        }
    }

    /**
     * @author : tianyu.wang
     * create at:  2021/5/6  2:09 下午
     * @description: x平方根
     */
    public static class Sqrt {

        public static void main(String[] args) {
            System.out.println(binarySearch(20));

            System.out.println(newton(20));
        }


        /***
         * @params [x]
         * @return int
         * @description :在不使用 sqrt(x) 函数的情况下，得到 x的平方根的整数部分
         * 解法一:二分查找
         *  * x的平方根肯定在0到x之间，使用二分查找定位该数字，该数字的平方一定是最接近x的，
         *  m平方值如果 大于x、则往左边找，如果小于等于x则往右边找
         *  * 找到0和X的最中间的数m，
         *  * 如果m * m > x，则m取x/2到x的中间数字，直到m * m < x，m则为平方根的整数部分
         *  * 如果m * m <= x，则取0到x/2的中间值，知道两边的界限重合，找到最大的整数，则为x平方根的整数 部分
         *  * 时间复杂度:O(logN)
         * @author tianyu.wang
         * @date 2021/5/6 4:23 下午
         */
        static int binarySearch(int x) {
            int l = 0, r = x, index = -1;
            while (l <= r) {
                //m平方值如果 大于x、则往左边找，如果小于等于x则往右边找
                int mid = l + (r - l) / 2;
                //如果m * m > x，则m取x/2到x的中间数字，直到m * m < x，m则为平方根的整数部分
                if ((long) mid * mid <= x) {
                    index = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return index;
        }

        //牛顿迭代
        static int newton(int x) {
            if (x == 0) return 0;
            return (int) sqrts(x,x);
        }

        /***
         * @params [i, x]
         * @return double
         * @description 牛顿迭代
         * 假设平方根是 i ，则 i 和 x/i 必然都是x的因子，而 x/i 必然等于 i ，
         * 推导出 i + x / i = 2 * i，得出 i = (i + x / i) / 2
         * 由此得出解法，i 可以任选一个值，只要上述公式成立，i 必然就是x的平方根，如果不成立， (i + x / i) / 2得出的值进行递归，直至得出正确解
         * @author tianyu.wang
         * @date 2021/5/6 4:32 下午
         */
        public static double sqrts(double i, int x) {

            double res=(i+x/i)/2;
            System.out.println("res:"+res+ " x:"+x+" i:"+i);
            if(res==i){
                return i;
            }else {
                return sqrts(res,x);
            }

        }
    }
}



