package com.datastructure.ds.stack;

/**
 * @author : tianyu.wang
 * create at:  2021/2/4  5:50 下午
 * @description:
 */
public class KuoHao {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();

        for(int i=0; i<20; i++) {
            stack.push(i+1);
        }

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        for(int i=0; i<18; i++) {
            System.out.println("The element is: " + stack.pop());
        }
    }

    public static boolean isOk(String s) {
        Stack<Character> brackets = new ArrayStack<>(20);
        char c[] = s.toCharArray();
        Character top;
        for (char x : c) {
            switch (x) {
                case '{':
                case '(':
                case '[':
                    brackets.push(x);//O(1)
                    break;
                case '}':
                    top = brackets.pop();//O(1)
                    if (top == null) return false;
                    if (top == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    top = brackets.pop();//O(1)
                    if (top == null) return false;
                    if (top == '(') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    top = brackets.pop();//O(1)
                    if (top == null) return false;
                    if (top == '[') {
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }

        return brackets.isEmpty();
    }
}
