/*
    - 题目描述：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
            不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    - 知识点：数组、双指针
    - 题目解析：
        （1）双指针，前指针指向遍历的索引，后指针指向未重复元素应该摆放的未知
        （2）发现重复元素则不更新后指针，元素不重复则更新后指针
        （3）最后返回后指针就是新的数组元素个数
    - 代码解析：
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 1, flag = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == flag) continue;
            else{
                flag = nums[i];
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}