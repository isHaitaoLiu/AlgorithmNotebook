/*
    - 题目描述：编写一个函数来查找字符串数组中的最长公共前缀。
               如果不存在公共前缀，返回空字符串 ""。
    - 知识点：二分、分治
    - 题目解析：
        （1）各个字串依次获取最长前缀
        （2）一次比较所有字符串中的一位字符
        （3）（1）的基础上的分治，分解，最后合并结果
        （4）（2）基础上的二分查找
    - 代码解析：
*/



class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        StringBuilder cur = new StringBuilder();
        for(int i = 1; i < strs.length; i++){
            cur.setLength(0);
            for(int j = 0; j < strs[i].length() && j < res.length(); j++){
                if(strs[i].charAt(j) == res.charAt(j)){
                    cur.append(strs[i].charAt(j));
                }else{
                    break;
                }
            }
            res = cur.toString();
        }
        return res;
    }
}