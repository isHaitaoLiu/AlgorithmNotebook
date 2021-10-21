
/*
    - 题目描述：
    给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
            '?' 可以匹配任何单个字符。
            '*' 可以匹配任意字符串（包括空字符串）。
            两个字符串完全匹配才算匹配成功。
    - 知识点：动态规划
    - 题目解析：
        正则表达式匹配的简化题
    - 代码解析：
*/




class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i++){
            if(dp[0][i - 1] == true && p.charAt(i - 1) == '*') dp[0][i] = true;
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j]; 
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}