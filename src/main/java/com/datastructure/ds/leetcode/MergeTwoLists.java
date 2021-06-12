package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/11  下午2:15
 * @description: 合并两个有序链表
 * 递归
 * 思路
 *
 * 我们可以如下递归地定义两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
 *
 * \left\{ \begin{array}{ll} list1[0] + merge(list1[1:], list2) & list1[0] < list2[0] \\ list2[0] + merge(list1, list2[1:]) & otherwise \end{array} \right.
 * {
 * list1[0]+merge(list1[1:],list2)
 * list2[0]+merge(list1,list2[1:])
 * ​
 *
 * list1[0]<list2[0]
 * otherwise
 * ​
 *
 *
 * 也就是说，两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并。
 *
 * 算法
 *
 * 我们直接将以上递归过程建模，同时需要考虑边界情况。
 *
 * 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，
 * 所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，
 * 然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），函数 mergeTwoList 至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)O(n+m)。

空间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+mn+m 次，因此空间复杂度为 O(n+m)O(n+m)。

 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  //交替合并字符串
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length(), idx = 0;
        char[] res = new char[len1 + len2];
        for(int i = 0; i < len1 || i < len2; ++i) {
            if(i < len1) res[idx++] = word1.charAt(i);
            if(i < len2) res[idx++] = word2.charAt(i);
        }
        return new String(res);
    }

    //股票最大利益
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }




}
