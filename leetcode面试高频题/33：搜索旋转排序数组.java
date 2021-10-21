/*
    - 题目描述：旋转数组求目标值
    - 知识点：二分法
    - 题目解析：
        二分即可解决
    - 代码解析：
*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(target >= nums[0] && (nums[mid] >= target || nums[mid] < nums[0])) r = mid;
            else if(target < nums[0] && nums[mid] < nums[0] && nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if(l >= nums.length || nums[l] != target) return -1;
        return l;
    }
}