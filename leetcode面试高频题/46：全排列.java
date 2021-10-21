/*
    - 题目描述：给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    - 知识点：回溯
    - 题目解析：回溯检索每一种排列方式即可
    - 代码解析：
*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), nums, visited);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited){
        if(cur.size() == nums.length) res.add(new ArrayList<>(cur));
        else{
            for(int i = 0; i < nums.length; i++){
                if(visited[i] == false){
                    visited[i] = true;
                    cur.add(nums[i]);
                    backtrack(res, cur, nums, visited);
                    cur.remove(cur.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}