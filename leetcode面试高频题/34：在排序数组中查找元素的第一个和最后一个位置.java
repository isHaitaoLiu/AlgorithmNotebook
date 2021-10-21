/*
    - 题目描述：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
              如果数组中不存在目标值 target，返回 [-1, -1]。
    - 知识点：二分法
    - 题目解析：
        （1）找左边界，然后向右查找
        （2）两次二分，分别找左右边界
    - 代码解析：
*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[]{-1, -1};
        //找左边界
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if(l >= nums.length || nums[l] != target) return res;
        res[0] = l;
        l = 0;
        r = nums.length - 1;
        //找右边界
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        res[1] = r;
        return res;
    }
}