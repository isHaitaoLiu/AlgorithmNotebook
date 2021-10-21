/*
    - 题目描述：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    - 知识点：哈希表
    - 题目解析： 哈希表存储元素值及其下标，遍历时查看HashMap中是否有元素和当前元素之和为target即可。
    - 代码解析： 
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                res[0] = map.get(need);
                res[1] = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}