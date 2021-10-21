/*
    - 题目描述：给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
              0 <= k <= input.length <= 10000
             0 <= input[i] <= 10000
    - 知识点：分治、快速排序、堆排序
    - 题目解析：
        （1）维护一个大小为K的堆即可
        （2）快速排序的划分思想
    - 代码解析：

*/



public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k > input.length){
            return res;
        }
        if(k == input.length){
            for(int i = 0; i < input.length; i++){
                res.add(input[i]);
            }
            return res;
        }
        int[] t = quickSort(input, 0, input.length - 1, k);
        for(int i = 0; i < t.length; i++){
            res.add(t[i]);
        }
        return res;
    }
    
    public int[] quickSort(int[] nums, int l, int r, int k){
        int i = l, j = r;
        while(i < j){
            while(j > i && nums[j] >= nums[l]) j--;
            while(j > i && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        if(i > k) return quickSort(nums, l, i - 1, k);
        if(i < k) return quickSort(nums, i + 1, r, k);
        return Arrays.copyOf(nums, k);
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}