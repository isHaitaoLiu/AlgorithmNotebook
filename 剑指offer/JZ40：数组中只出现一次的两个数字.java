/*
    - 题目描述：一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    - 知识点：位运算
    - 题目解析：
            考虑位运算中的异或运算(xor)，如果两个相同的数字异或，结果0；
            考虑一个简单的题目【数组中只有一个数字出现了一次，其他数字都出现两次】，可以用异或运算直接遍历，得到的结果就是那个单独的数字
            考虑这个题目，如果也使用异或运算作遍历，则得到的结果是 两个单独数字的异或的结果xor_total
            如果能找到一种方法可以把所有数字分成两组，使得：
            （1）两个只出现一次的数字在不同的组中；
            （2）相同的数字会被分到相同的组中。 就可以得到答案

            将xor_total写成二进制，找到其中一个不为0的位，得到那个数x，再利用相与操作（&），就是分开两组的关键；
            因为：
            （1）两个单独的数字在那个位的异或结果为1， 说明两个数字在那个位的数字是不同的，那么和x的与运算的结果是不同的
            （2）如果两个数相同，则和x的与运算是相同的，可以被分在同一个组
    - 代码解析：
*/


public class Solution {
    public int[] FindNumsAppearOnce (int[] array) {
        int xor_total = 0;
        for(int i = 0; i < array.length; i++){
            xor_total ^= array[i];
        }
        int min_idx_of_one = 1;
        while((min_idx_of_one & xor_total) == 0){
            min_idx_of_one <<= 1;
        }
        int num1 = 0, num2 = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & min_idx_of_one) == 0){
                num1 ^= array[i];
            }
            else{
                num2 ^= array[i];
            }
        }
        int[] res = new int[2];
        res[0] = Math.min(num1, num2);
        res[1] = Math.max(num1, num2);
        return res;
    }
}