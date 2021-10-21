/*
    - 题目描述：
        求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    - 知识点：
    - 题目解析：
        考虑递归解：
            int Sum_Solution(int n) {
                if (n == 1) return n;
                return n + Sum_Solution(n-1);
            }
        递归出口成立则结束递归，否则继续递归；
        考虑表达式 A && B ，A成立，则继续计算 A && B，否则将短路
        所以这里将 n != 1这个条件看作A， n的累加看作B即可
    - 代码解析：
*/


public class Solution {
    public int Sum_Solution(int n) {
        boolean x = (n > 1) && (n += Sum_Solution(n - 1)) > 0;
        return n;
    }
}