/*
    - 题目描述：
        给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
        不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
        对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
    - 知识点：数组
    - 题目解析：
        （1）最朴素的方法就是直接为每一个B[i]计算结果，时间复杂度为 n ^ 2
        （2）考虑到，B[i]是由左侧 A[0]*A[1]*...*A[i - 1]，再乘以右侧  A[i + 1]*A[i + 2]*...*A[n - 1]
            而 A[0]*A[1]*...*A[i - 1] = A[0]*A[1]*...*A[i - 2] * {A[i - 1]},
            也就是说，可以把累乘结果记录下来，因此，算左侧只需要一次遍历，算右侧也只需要一次遍历
    - 代码解析：
*/



import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int left = 0, right = 0;
        for(int i = 0; i < n; i++){
            if(i == 0) left = 1;
            else{
                left = left * A[i - 1];
            }
            res[i] = left;
        }
        for(int i = n - 1; i >= 0; i--){
            if(i == n - 1) right = 1;
            else{
                right = right * A[i + 1];
            }
            res[i] *= right;
        }
        return res;
    }
}