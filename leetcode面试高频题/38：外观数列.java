/*
    - 题目描述：给定一个正整数 n ，输出外观数列的第 n 项。
                「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
                例如 1121 的描述就是 211211，2个1，1个2，1个1
    - 知识点：递归
    - 题目解析：
    - 代码解析：
*/


class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        else{
            String pre = countAndSay(n - 1);
            StringBuilder res = new StringBuilder();
            char cur = pre.charAt(0);
            int counter = 0;
            for(int i = 0; i < pre.length(); i++){
                char c = pre.charAt(i);
                if(c == cur) counter++;
                else{
                    res.append(counter);
                    res.append(cur);
                    cur = c;
                    counter = 1;
                }
            }
            res.append(counter);
            res.append(cur);
            return res.toString();
        }
    }
}