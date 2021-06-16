/*
    题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    知识点：动态规划
    题目解析：青蛙的只可能从下面一级台阶和下面两级台阶跳上来，因此青蛙某个台阶的跳法总数取决于下面两个台阶的跳法，与其他先前的台阶无关，因此可以使用动态规划进行解答。
*/



public class Solution {
    public int jumpFloor(int target) {
        if(target == 0 || target == 1) return 1;
        int[] momo = new int[target + 1];
        momo[0] = 1;
        momo[1] = 1;
        for(int i = 2; i <= target; i++){
            momo[i] = momo[i - 1] + momo[i - 2];
        }
        return momo[target];
    }
}


//空间优化版
public class Solution {
    public int jumpFloor(int target) {
        if(target == 0 || target == 1) return 1;
        int[] momo = new int[2];
        momo[0] = 1;
        momo[1] = 1;
        for(int i = 2; i <= target; i++){
            int temp = momo[0];
            momo[0] = momo[1];
            momo[1] = momo[0] + temp;
        }
        return momo[1];
    }
}