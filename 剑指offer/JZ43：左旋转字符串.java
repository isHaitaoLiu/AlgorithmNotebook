/*
    - 题目描述：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
              对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出（保证 K 小于等于 S 的长度）。
              例如，字符序列S=”abcXYZdef”,要求输出循环左移 3 位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
    - 知识点：字符串
    - 题目解析：
        n有可能大于字符串长度，需要先处理得到n = n % len；获取左半部分n个单位的子串，拼接到右边即可
    - 代码解析：
*/


public class Solution {
    public String LeftRotateString(String str,int n) {
        if("".equals(str)) return "";
        n = n % str.length();
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}