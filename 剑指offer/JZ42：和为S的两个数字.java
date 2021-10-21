/*
    - 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
              返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。

    - 知识点：双指针
    - 题目解析：
            设置左指针l, 右指针r, 分别向右、向左滑动，直到lr相遇 --->
                如果 arr[l] + arr[r] == sum，则尝试更新结果；
                如果 arr[l] + arr[r] > sum， 则左指针右移；
                如果 arr[l] + arr[r] < sum， 则右指针左移.
    - 代码解析：
*/


public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int l = 0, r = array.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        int a = -1, b = -1;
        while(l < r){
            if(array[l] + array[r] == sum){
                if(array[l] * array[r] < max){
                    a = array[l];
                    b = array[r];
                    max = array[l] * array[r];
                } 
            }
            if(array[l] + array[r] < sum) l++;
            else r--;
        }
        if(a == -1) return res;
        res.add(a);
        res.add(b);
        return res;
    }
}