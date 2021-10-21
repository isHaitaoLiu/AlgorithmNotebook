/*
    - 题目描述：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    - 知识点：递归、二分
    - 题目解析：寻找两个数组最中间的两个数求平均，则题目可改为，求取两个有序数组中最小的第k个数；
              具体来说，分别查找两个数组的第k/2个位置的数，较小的那个部分左半边需要排除，因为不可能存在于那个部分；
              去除后，需要更新k值。如此递归查找
    - 代码解析： 递归边界需要注意，如果某个数组边界超过数组长度，则直接查找另一个数组即可
                如果k==1，则直接选取两个数组当前位置最小的那个值即可。
                为什么k==1是边界？ 因为当k=1时，k - k/2 = 1，所以不会更新
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int first = (nums1.length + nums2.length + 1) / 2;
        int second = (nums1.length + nums2.length + 2) / 2;
        double res = getKth(nums1, 0, nums2, 0, first) + getKth(nums1, 0, nums2, 0, second);
        return res / 2;
    }

    public int getKth(int[] nums1, int l1, int[] nums2, int l2, int k){
        if(l1 >= nums1.length) return nums2[l2 + k - 1];
        if(l2 >= nums2.length) return nums1[l1 + k - 1];
        if(k == 1) return Math.min(nums1[l1], nums2[l2]);

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if(l1 + k/2 - 1 < nums1.length) mid1 = nums1[l1 + k/2 - 1];
        if(l2 + k/2 - 1 < nums2.length) mid2 = nums2[l2 + k/2 - 1];
        if(mid1 < mid2){
            return getKth(nums1, l1 + k/2, nums2, l2, k - k/2);
        }else{
            return getKth(nums1, l1, nums2, l2 + k/2, k - k/2);
        }
    }
}