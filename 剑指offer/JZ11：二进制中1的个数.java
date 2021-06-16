/*
    - 题目描述：输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
    - 知识点：位运算
    - 题目解析：
    - 代码解析：
        法1: n & 1可以获得n的补码的末位的值，之后通过 >>> 位运算将n的最后一位移除，循环进行即可计算1的个数
        法2: n & (n - 1) 会把 n 最右边的1变成0，因此循环进行即可统计1的个数
 */





public class Solution {
    public int NumberOf1(int n){
        int counter = 0;
        while(n != 0){
            counter += (n & 1);
            n = n >>> 1;
        }
        return counter;
    }
}

/*
    n          :  11101000
    n - 1      :  11100111
    n & (n - 1):  11100000
    最后一个1变为0，后面的所有0变为1，因此，n - 1最后位的1以及之后的所有数字都与n不同
 */


public class Solution {
    public int NumberOf1(int n){
        int counter = 0;
        while(n != 0){
            counter++;
            n = n & (n - 1);
        }
        return counter;
    }
}
