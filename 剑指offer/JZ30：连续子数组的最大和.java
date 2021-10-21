/*
    - 题目描述：输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
              求所有子数组的和的最大值。要求时间复杂度为 O(n).
    - 知识点：动态规划
    - 题目解析：
        dp数组维护以当前数为末尾的，连续一串数的和的最大值；
        如果dp[i - 1]为负数，则代表前面的那一串数是无效数，将其舍去，新串只有一个；
        如果dp[i - 1]为正数，则代表以当前数为结尾的连续串，最大值需要加上前面一串
    - 代码解析：

*/


public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for(int i = 1; i < array.length; i++){
            if(dp[i - 1] < 0) dp[i] = array[i];
            else dp[i] = dp[i - 1] + array[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}