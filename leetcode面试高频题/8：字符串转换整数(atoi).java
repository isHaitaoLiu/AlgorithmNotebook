/*
    - 题目描述：请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
    - 知识点：数学
    - 题目解析：正数溢出判定
            res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur >= Integer.MAX_VALUE % 10
              负数溢出判定
            res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && cur >= -(Integer.MIN_VALUE % 10)
    - 代码解析： 
*/



class Solution {
    public int myAtoi(String s) {
        int res = 0, idx = 0;
        boolean flag = true;
        while(idx < s.length() && s.charAt(idx) == ' ') idx++;
        if(idx < s.length()){
            char c = s.charAt(idx);
            if(c == '+') {
                flag = true;
                idx++;
            }else if(c == '-'){
                flag = false;
                idx++;
            }
        }
        while(idx < s.length()){
            char c = s.charAt(idx);
            if(c < '0' || c > '9') break;
            int cur = c - '0';
            if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur >= Integer.MAX_VALUE % 10){
                res = Integer.MAX_VALUE;
                return res;
            }
            if(res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && cur >= -(Integer.MIN_VALUE % 10)){
                res = Integer.MIN_VALUE;
                return res;
            }
            cur = flag == true ? cur : -cur;
            res = res * 10 + cur;
            idx++;
        }
        return res;
    }
}