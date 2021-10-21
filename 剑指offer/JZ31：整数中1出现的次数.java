/*
    - 题目描述：输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
              例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
    - 知识点：数学
    - 题目解析：
        https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
    - 代码解析：
        num是当前数，cur 为当前位， 每次计算某一位中出现1的次数；high是cur左侧数值，low是cur数值
        （1）当cur = 0时， 不超过num的数的1出现的次数，只与high有关
                2304   --->  出现1的范围是 0010-2219  即0-229， 230个， high * digit
        （2）当cur = 1时， 不超过num的数的1出现的次数，与high和low有关 
                2314   --->  出现1的范围是 0010-2314， 即0-234， 235个, high * digit + low + 1
        （3）当cur = 2-9时， 不超过num的数的1出现的次数，与high有关
                2324   ---> 出现1的范围是 0010-2319， 即0-239, 240个，  (high + 1) * 10
 */


public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1, res = 0;
        int low = 0, cur = n % 10, high = n / 10;
        while(!(high == 0 && cur == 0)){
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            
            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }
}