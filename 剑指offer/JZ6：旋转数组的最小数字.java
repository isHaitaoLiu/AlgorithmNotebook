/*
    - 题目描述：
        - 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        - 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        - NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    - 知识点：二分法
    - 题目解析：
        - 在leetcode上，根据数组元素是否可以重复分为了2个题（不可重复leetcode[153]，可重复leetcode[154]），循序渐进更加容易理解此题
        - （1）数组元素不重复的情况，则使用二分法查到的元素大于等于array[0]时最小值在右侧，查到的元素小于array[0]时最小值在右侧
        - （2）数组元素允许重复的情况，意味着右半部分也可能出现==array[0]的情况，因此不能简单地认为使用二分法查到的元素大于等于array[0]时最小值在右侧，
        为了解决这个问题，可以先将右侧与array[0]相等的元素都排除，这样就退化到上面的情况，二分法可解
        - 注意！！！：在（2）->（1）的处理后或者（1）本身，都有一个特殊情况，即数组完全升序，此时最小值为array[0]，需要进行特判，检查array[0]是否小于array[length - 1]，如果是直接返回array[0]
    - 代码解析：
        - 先对尾部元素进行处理
        - 进行特判，最小值是否为头部元素
        - 进行二分查找
*/






import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int l = 0, r = array.length - 1;
        while(0 < r && array[0] == array[r]) r--;
        if(array[0] < array[r]) return array[0];
        while(l < r){
            int mid = l + r >> 1;
            if(array[mid] < array[0]) r = mid;
            else l = mid + 1;
        }
        return array[l];
    }
}