/*
    - 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
              假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）
    - 知识点：二叉树、二叉搜索树、排序
    - 题目解析：判断一个序列是否可能是一个二叉搜索树的后续遍历，二叉搜索树满足左子树小于根节点，右子树大于根节点
              因此后续遍历则是，最后一个元素是根节点，可以将序列分为左右两个子序列
    - 代码解析：
            检查最右边的元素，是否能够将序列分为左右两个子序列，左子序列比该元素小，右子序列比该元素大
*/


public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return check(sequence, 0, sequence.length - 1);
    }
    
    public boolean check(int[] arr, int l, int r){
        if(l >= r) return true;
        int mid = arr[r];
        int idx = l;
        while(idx < r){
            if(arr[idx] > mid) break;
            idx++;
        }
        int midr = idx;
        while(idx < r){
            if(arr[idx] < mid) return false;
            idx++;
        }
        return check(arr, l, midr - 1) && check(arr, midr, r - 1);
    }
}