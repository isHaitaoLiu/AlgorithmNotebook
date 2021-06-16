/*
    - 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    - 知识点：动态规划
    - 题目分析：青蛙的某一个台阶的跳法与前面各个台阶都有关，根据题目描述，很容易得到递推公式：f[n] = f[n - 1] + f[n - 2] + ...... + f[0]，因而可以写出下面的第一个代码；
      另一方面，观察到f[n - 1] = f[n - 2] + ...... + f[0], 因而f[n] = f[n - 1] * 2，可以得到时间优化版本，时间复杂度降低到O(n)；
      此外，在时间优化版本基础上可以发现，只需要记录前面一个状态，因此还可进行空间优化，达到O(1)空间复杂度
 */


public class Solution {
    public int jumpFloorII(int target) {
        if(target == 0 || target == 1) return 1;
        int[] momo = new int[target + 1];
        momo[0] = momo[1] = 1;
        for(int i = 2; i <= target; i++){
            for(int j = 0; j <= i - 1; j++){
                momo[i] += momo[j];
            }
        }
        return momo[target];
    }
}


//时间优化版本
public class Solution {
    public int jumpFloorII(int target) {
        if(target == 0 || target == 1) return 1;
        int[] momo = new int[target + 1];
        momo[0] = momo[1] = 1;
        for(int i = 2; i <= target; i++){
            momo[i] = 2 * momo[i - 1];
        }
        return momo[target];
    }
}