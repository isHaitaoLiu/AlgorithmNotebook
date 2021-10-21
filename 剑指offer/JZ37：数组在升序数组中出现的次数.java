/*
    - 题目描述：统计一个数字在升序数组中出现的次数。
    - 知识点：二分法
    - 题目解析：
        （1）法一：最直观直接统计肯定不是题目本意，大概率超时
        （2）法二：数组和字符串查找问题经常使用二分法，特别是有序数组，更容易想到使用二分法，
            先利用二分法找到最左边或者最右边的k值，再到数组中向左或者向右扫描即可
    - 代码解析：
*/



public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int l = 0, r = array.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(array[mid] >= k) r = mid;
            else l = mid + 1;
        }
        if(l >= array.length || array[l] != k) return 0;
        int res = 0;
        for(int i = l; i < array.length && array[i] == k; i++){
            res++;
        }
        return res;
    }
}