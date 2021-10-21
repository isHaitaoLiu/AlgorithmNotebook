/*
    - 题目描述：
        给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
        在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    - 知识点：双指针
    - 题目解析：
        容器能装多少水，取决于较短的木板。先计算最边界的容量，双指针向内滑动，
        根据上述理论注意到，如果想要装水更多，则需要提高短板的高度，因此，每次都是去移动短板指针，
        直到可能盛水更多，则尝试更新结果。
    - 代码解析：
*/





class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while(l < r){
            int high = Math.min(height[l], height[r]);
            res = Math.max(res, high * (r - l));
            if(height[l] <= height[r]){
                int low = height[l];
                while(l < r && height[l] <= low) l++;
            }else{
                int low = height[r];
                while(l < r && height[r] <= low) r--;
            }
        }
        return res;
    }
}