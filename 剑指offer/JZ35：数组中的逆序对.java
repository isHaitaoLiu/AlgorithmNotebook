/*
    - 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
              输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
    - 知识点：归并排序、分治
    - 题目解析：
           考虑归并排序，将两个有序数组合并的步骤，如果右侧arr[j] < 左侧arr[j]，说明这里出现 mid - i + 1个逆序对，
           因为从i - mid在内的所有数都会比arr[j]大；
           那么从数组长度为1开始进行计算，先计算逆序对，再将数组合并；
           （这里需要考虑为什么可以合并，合并之后，并不会影响这两个数组的合数组相对于其他部分的逆序对的数量，因为要么都在前面，要么都在后面）
    - 代码解析：
*/

public class Solution {
    public int InversePairs(int [] array) {
        int[] temp = new int[array.length];
        return sort(array, 0, array.length - 1, temp) % 1000000007;
    }
    
    public int sort(int[] array, int l, int r, int[] temp){
        if(l >= r) return 0;
        int mid = l + r >> 1;
        
        int cl = sort(array, l, mid, temp);
        int cr = sort(array, mid + 1, r, temp);
        
        return cl + cr + merge(array, l, mid, r, temp);
    }
    
    public int merge(int[] array, int l, int mid, int r, int[] temp){
        int i = l, j = mid + 1;
        int idx = 0;
        int count = 0;
        
        while(i <= mid && j <= r){
            if(array[i] <= array[j]){
                temp[idx++] = array[i++];
            }else{
                count += (mid - i + 1);
                temp[idx++] = array[j++];
            }
        }
        
        while(i <= mid) temp[idx++] = array[i++];
        while(j <= r) temp[idx++] = array[j++];
        
        idx = 0;
        while(l <= r) array[l++] = temp[idx++];
        
        return count % 1000000007;
        //array = Arrays.copyOf(temp, array.length);
    }
}