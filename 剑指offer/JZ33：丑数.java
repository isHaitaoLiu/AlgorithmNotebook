/*
    - 题目描述：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 
              习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    - 知识点：数学、动态规划
    - 题目解析：
          一个丑数必须是1 或者 更小的丑数 ， 乘以 2、3、5得到
          利用一个dp数组来从小到大依次保存丑数；
          也就是说 dp[i] = dp[0 - i-1] 中的某个数，乘 2， 3， 5得到，
          因此可以设置a,b,c来滚动分别保存乘2， 3， 5得到的最小丑数，
          每次循环，得到最小的一个丑数，将其放入，对应的a/b/c右移一位
    - 代码解析：

*/


public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        int[] dp = new int[index + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for(int i = 2; i <= index; i++){
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[index];
    }
}