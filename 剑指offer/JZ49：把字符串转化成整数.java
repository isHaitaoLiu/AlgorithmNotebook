/*
    - 题目描述：
        将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
    - 知识点：字符串
    - 题目解析：
        （1）首先判断首位，首位必须是 + - 数字 三者之一，如果是+-，则用boolean记录数字的正负值，然后去掉首位
        （2）之后重后往前遍历，遇到 非 ‘0’ - ‘9’的字符，直接返回，否则进行累积
        （3）注意一个细节，由于使用int记录结果，必须在整数溢出之前判断，例如res > Integer.MAX_VALUE / 10，则说明它如果再乘以10，
        就发生溢出，直接返回；如果在累积之后使用 res > Integer.MAX_VALUE，是无效的
    - 代码解析：
*/


public class Solution {
    public int StrToInt(String str) {
        if(str == null || "".equals(str) == true)
            return 0;
        boolean flag = true;
        int res = 0;
        if(str.charAt(0) == '+'){
            flag = true;
            str = str.substring(1, str.length());
        }else if(str.charAt(0) == '-'){
            flag = false;
            str = str.substring(1, str.length());
        }
        char[] strs = str.toCharArray();
        int base = 1;
        for(int i = strs.length - 1; i >= 0; i--){
            char c = strs[i];
            if(c < '0' || c > '9') return 0;
            if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)
                return 0;
            res += base * (c - '0');
            base *= 10;
        }
        res = flag == true ? res : -res;
        return res;
    }
}