/*
    - 题目描述：
        写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    - 知识点：位运算
    - 题目解析：
        两个整数进行 ^运算, 可以得到不考虑进位的结果；
        两个整数进行 &运算 ，有1表示在那一位产生进位 ， <<操作则表示得到进位发生后的结果；
        二者结合可以的得到最终值。
    - 代码解析：
*/


public class Solution {
    public int Add(int num1,int num2) {
        int res = 0, carry = 0;
        do{
            res = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = res;
            num2 = carry;
        }while(carry != 0);
        return res;
    }
}