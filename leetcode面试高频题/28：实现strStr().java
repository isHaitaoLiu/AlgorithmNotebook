/*
    - 题目描述：给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 
              字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。needle长度为0则返回0
    - 知识点：字符串匹配、kmp算法
    - 题目解析：
        （1）暴力法
        （2）kmp算法
    - 代码解析：
*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i + needle.length() <= haystack.length(); i++){
            boolean flag = true;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag == true) return i;
        }
        return -1;
    }
}