/*
    - 题目描述：给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
              如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
              不允许使用long
    - 知识点：数学
    - 题目解析：考察不使用long时的溢出判定，res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10则溢出
    - 代码解析： 
*/


class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10){
                return 0;
            }else{
                int cur = x % 10;
                x = x / 10;
                res = res * 10 + cur;
            }
        }
        return res;
    }
}