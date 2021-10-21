/*
    - 题目描述：给你一个字符串 s，找到 s 中最长的回文子串。
    - 知识点：动态规划、双指针
    - 题目解析：（1）双指针，中心扩展法，枚举所有的中心，分别向两边扩展
              （2）动态规划，dp[i][j]数组保存 ij 子串是否是回文串，每次是回文串时，更新结果
    - 代码解析： 
*/



class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for(int j = 0; j < s.length(); j++){
            for(int i = j; i >= 0; i--){
                if(i == j || i == j - 1 && s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                else if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) dp[i][j] = true;
                if(dp[i][j] == true && maxLen < j - i + 1){
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}