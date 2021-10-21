/*
    - 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
              例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
    - 知识点：字符串、字典序、排序规则
    - 题目解析：
        如果字符串a,b满足 a + b < b + a，则我们认为 ab < ba，如果对所有字符串都做一个排序，贪心
        则最后全部拼接可以得到想要的结果
    - 代码解析：

*/


public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for(int i = 0; i < strs.length; i++){
            strs[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            return (a + b).compareTo(b + a);
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}