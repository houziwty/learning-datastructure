package com.datastructure.ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tianyu.wang
 * create at:  2021/6/1  4:43 下午
 * @description:井字游戏
 * 用字符串数组作为井字游戏的游戏板 board，判断该游戏板有没有可能最终形成 游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。 两个玩家轮流将字符放入空位，一个玩家执X棋，另一个玩家执O棋
 * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同(且非空)的字符填充任何行、列或对角线时，游戏结束，board生成 分类讨论
 */
public class ValiBoard {
    public static boolean validBoard(String[] board) {
        return true;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //思路是构造一个获取当前子树的深度的函数 depth(root) （即 面试题55 - I. 二叉树的深度 ），通过比较某子树的左右子树的深度差 abs(depth(root.left) - depth(root.right)) <= 1 是否成立，来判断某子树是否是二叉平衡树。若所有子树都平衡，则此树平衡。
    //
    //算法流程：
    //isBalanced(root) 函数： 判断树 root 是否平衡
    //
    //特例处理： 若树根节点 root 为空，则直接返回 truetrue ；
    //返回值： 所有子树都需要满足平衡树性质，因此以下三者使用与逻辑 \&\&&& 连接；
    //abs(self.depth(root.left) - self.depth(root.right)) <= 1 ：判断 当前子树 是否是平衡树；
    //self.isBalanced(root.left) ： 先序遍历递归，判断 当前子树的左子树 是否是平衡树；
    //self.isBalanced(root.right) ： 先序遍历递归，判断 当前子树的右子树 是否是平衡树；
    //depth(root) 函数： 计算树 root 的深度
    //
    //终止条件： 当 root 为空，即越过叶子节点，则返回高度 00 ；
    //返回值： 返回左 / 右子树的深度的最大值 +1+1 。
    //时间复杂度 O(N log N)O(NlogN)

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  //哈希表统计： 遍历字符串 ss 时，使用哈希表（记为 dicdic ）统计 各字符最后一次出现的索引位置 。
    //左边界 ii 获取方式： 遍历到 s[j]s[j] 时，可通过访问哈希表 dic[s[j]]dic[s[j]] 获取最近的相同字符的索引 ii 。
    //复杂度分析：
    //时间复杂度 O(N)O(N) ： 其中 NN 为字符串长度，动态规划需遍历计算 dpdp 列表。
    //空间复杂度 O(1)O(1) ： 字符的 ASCII 码范围为 00 ~ 127127 ，哈希表 dicdic 最多使用 O(128) = O(1)O(128)=O(1) 大小的额外空间。
  public int lengthOfLongestSubstring(String s) {
      Map<Character, Integer> dic = new HashMap<>();
      int res = 0, tmp = 0;
      for(int j = 0; j < s.length(); j++) {
          int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
          dic.put(s.charAt(j), j); // 更新哈希表
          tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
          res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
      }
      return res;
  }


}
