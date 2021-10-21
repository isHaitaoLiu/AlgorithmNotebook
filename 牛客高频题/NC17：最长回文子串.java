/*
    - 题目描述：对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
              给定字符串A以及它的长度n，请返回最长回文子串的长度。
    - 知识点：动态规划
    - 题目解析：dp[i][j]表示i - j 的子串是否构成回文串；只有三种情况可以构成回文串（1）ij相等（2）i = j - 1，且A[i] == A[j] （2）A[i] == A[j] 且 i+1 - j-1是一个回文串
              因此，从窄到宽，枚举左右边界即可判断是否为回文串，如果是回文串，尝试更新最大长度。
    - 代码解析： 
*/

public class Solution {
    public int getLongestPalindrome(String A, int n) {
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int j = 0; j <= n - 1; j++){
            for(int i = j; i >= 0; i--){
                if(i == j || j - i == 1 && A.charAt(i) == A.charAt(j)) dp[i][j] = true;
                else if(A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1] == true) dp[i][j] = true;
                if(dp[i][j] == true){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}