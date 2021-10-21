/*
    - 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
              由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
              1<=数组长度<=50000，0<=数组元素<=10000
    - 知识点：计数、投票法
    - 题目解析：
        如果一个数出现次数超过数组的一半，那么这个数就是一个众数，如何找出众数？
        设定一个计数器，依次扫描数组，
        如果计数器为0，代表没有候选的众数，将当前数设置为候选众数，计数器+1；
        如果计数器不为0，代表有候选众数，如果当前数与候选众数相同，则计数器+1，不同则-1；
        最后，如果候选众数存在，则一定是候选众数，统计其次数；如果不存在，则候选众数次数必然小于等于数组一半

        通俗地来说，让众数与每一位非众数“单挑”，两者都消去，众数如果存在，则必然能够胜出
    - 代码解析：

*/


public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int counter = 0;
        int cur = -1;
        for(int i = 0; i < array.length; i++){
            if(counter == 0){
                cur = array[i];
                counter++;
            }
            else{
                if(cur == array[i]) counter++;
                else counter--;
            }
        }
        counter = 0;
        for(int i = 0; i < array.length; i++){
            if(cur == array[i]) counter++;
        }
        if(counter > array.length/2) return cur;
        return 0;
    }
}