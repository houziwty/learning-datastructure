package com.datastructure.ds.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : tianyu.wang
 * create at:  2021/6/8  下午3:09
 * @description:电话号码的字母组合 方法一：回溯
 * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
 * <p>
 * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
 * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，
 * 并将其中的一个字母插入到已有的字母排列后面，
 * 然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。
 * 然后进行回退操作，遍历其余的字母排列。
 * <p>
 * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，
 * 则会舍弃不可行的解。在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，
 * 直接穷举所有的解即可。
 * 时间复杂度：O(3^m \times 4^n)O(3M×4n)
 * 空间复杂度：O(m+n)O(m+n)
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());

        return combinations;
    }

    static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            System.out.println("combinations:" + combination.toString());
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);

            String letters = phoneMap.get(digit);
            System.out.println("digit:" + digit+"   letters:" + letters);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {

                combination.append(letters.charAt(i));

                System.out.println("i:"+i+"  letters.charAt(i):"+ letters.charAt(i)+  "  index:" + combination.charAt(index));


                backtrack(combinations, phoneMap, digits, index + 1, combination);



                combination.deleteCharAt(index);
            }
        }

    }
}
