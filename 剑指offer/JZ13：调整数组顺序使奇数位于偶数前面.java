/*
    - 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    - 知识点：排序
    - 题目解析：
    - 代码解析：
        解法1 - 计算奇数的总数，设置一个新数组，扫描旧数组，分别将奇数和偶数依次填入不同的位置
        解法2 - 冒泡排序
*/




public class Solution {
    public int[] reOrderArray (int[] array) {
        // write code here
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 1) counter++;
        }
        int[] res = new int[array.length];
        int l = 0, r = counter;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 1) res[l++] = array[i];
            else res[r++] = array[i];
        }
        return res;
    }
}