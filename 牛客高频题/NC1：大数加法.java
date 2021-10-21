/*
    - 题目描述：以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
             （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
    - 知识点：字符串
    - 题目解析： 不用库函数，使用基础操作完成大数加法
    - 代码解析： 根据小学学的加法法则， 从后往前遍历，每轮遍历记录【和】以及【进位】，
               每次遍历的【当前和】 = （a + b + 【前一个进位】） % 10，【当前进位】 = 【当前和】/ 10；
               遍历的终止条件为两个字符串都到头了，且进位为0
*/

public class Solution {
    public String solve (String s, String t) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0, i = s.length() - 1, j = t.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            int a = i < 0 ? 0 : s.charAt(i--) - '0';
            int b = j < 0 ? 0 : t.charAt(j--) - '0';
            sum = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}