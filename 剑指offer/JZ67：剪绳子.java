/*
    - 题目描述：
        给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
        每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
        例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    - 知识点：动态规划
    - 题目解析：
        如果想要直到长度为n的绳子怎么剪可以得到最长的乘积，那么必然是多个长度<n的绳子乘积结果相乘得来，因而可以使用动态规划
        dp[i]代表长度为i的绳子分为若干段，可以得到的最长乘积
        （1）法1，dp[i]包括剪过或没剪过的情况
        （2）法2，dp[i]一定是剪过的情况
    - 代码解析：
*/

public class Solution {
    public int cutRope(int target) {
        int[] arr = new int[target + 1];
        if(target == 2) return 1;
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i < arr.length; i++){
            int res = Integer.MIN_VALUE;
            for(int j = 1; j < i; j++){
                res = Math.max(res, arr[j] * arr[i - j]);
                res = Math.max(res, arr[j] * (i - j));
                res = Math.max(res, j * arr[i - j]);
                res = Math.max(res, j * (i - j));
            }
            arr[i] = res;
        }
        return arr[target];
    }
}


public class Solution {
    public int cutRope(int target) {
        int[] dp = new int[target + 1];
        if(target == 2 || target == 3) return target - 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int res = Integer.MIN_VALUE;
        for(int i = 4; i < dp.length; i++){
            for(int j = 1; j <= i / 2; j++){
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return dp[target];
    }
}