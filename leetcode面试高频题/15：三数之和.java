/*
    - 题目描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
              使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    - 知识点：排序、双指针
    - 题目解析：
        （1）排序之和注意去重，即使用过的数字需要跳过，不再使用
        （2）注意第二个和第三个数字是否碰撞，即是否重复使用
        （3）按照逻辑，小于0左指针右移动，大于0右指针左移动
    - 代码解析：
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                while(j < k && j > i + 1 && nums[j] == nums[j - 1]) j++;
                while(j < k && k < nums.length - 1 && nums[k] == nums[k + 1]) k--;
                if(j >= k) break;
                if(nums[i] + nums[j] + nums[k] == 0){
                    ArrayList<Integer> subRes = new ArrayList<>();
                    subRes.add(nums[i]);
                    subRes.add(nums[j]);
                    subRes.add(nums[k]);
                    res.add(subRes);
                    j++;
                    k--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}