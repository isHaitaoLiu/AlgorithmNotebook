/*
    - 题目描述：给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
              请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
    - 知识点：哈希
    - 题目解析：
        正确的正整数数组应该是【1，2，3，4，5，6，7...】
        如果当前位置元素正确，则不做任何操作
        如果当前位置元素不正确，则将其交换到正确的位置（注意！如果两个数相同，则不交换，否则无限循环）
        最后检查不正确的位置，则那个元素缺失
    - 代码解析：
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == i + 1) continue;
            else{
                while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                    swap(nums, i, nums[i] - 1);
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}