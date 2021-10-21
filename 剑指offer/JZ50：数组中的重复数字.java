/*
    - 题目描述：
        在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
        也不知道每个数字重复几次。请找出数组中任一一个重复的数字。 
        例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
    - 知识点：数组
    - 题目解析：
        计数排序的思想即可，由于数组中数据大小范围是 0 - (n-1)，开辟一个长度n的数组，可以直接记录其数量
    - 代码解析：
*/


public class Solution {
    public int duplicate (int[] numbers){
        int[] flag = new int[numbers.length];
        int i = 0;
        for(i = 0; i < numbers.length; i++){
            if(flag[numbers[i]] != 0) return numbers[i];
            flag[numbers[i]]++;
        }
        return -1;
    }
}