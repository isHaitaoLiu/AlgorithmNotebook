/*
    - 题目描述：给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    - 知识点：双指针
    - 题目解析： 容器能装多少水取决于容器左右边界的短板高度，而这里高低不平的短板可以看作这个容器有多个子容器。
               双指针法，指针定位于容器的边界，确定较矮的那个边界的高度min。左、右指针分别向右、左搜索，只有当高度小于min时才可蓄水，累加蓄水量，
               直到左右边界都大于min，则一个子容器的蓄水量计算完毕，需要更新最矮边界计算其他子容器。
    - 代码解析： 
*/

public class Solution {
    public long maxWater (int[] arr) {
        // write code here
        int l = 0, r = arr.length - 1;
        long res = 0;
        while(l < r){
            int min = Math.min(arr[l], arr[r]);
            while(l < r && arr[l] <= min){
                res += min - arr[l];
                l++;
            }
            while(l < r && arr[r] <= min){
                res += min - arr[r];
                r--;
            }
        }
        return res;
    }
}