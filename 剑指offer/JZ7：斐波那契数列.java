/*
    题目描述：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n <= 39
    知识点：动态规划    
    题目解析：利用数组存储已经计算过的函数值，防止重复计算
    代码解析：无
 */


public class Solution {
    public int Fibonacci(int n) {
        int[] momo = new int[40];
        momo[0] = 0;
        momo[1] = 1;
        for(int i = 2; i <= 39; i++){
            momo[i] = momo[i - 1] + momo[i - 2];
        }
        return momo[n];
    }
}