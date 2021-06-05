/*
    知识点：二分法、二维数组的二分查找
    题目分析：
        - 行和列方向上都按照递增排序，因此行和列方向上都可以分别应用二分法进行查找。排序的存在可以得到以下结论：
        - 对于位置[i, j]的元素值num，从[i, j]开始的右下角子方阵任一元素必然比num大，因此二分查找时找到的值比num大时，可以排除此区域，搜索[i, j]上方和左侧的子方阵
        - 同理, 对于位置[i, j]的元素值num，从[i, j]开始的左上角子方阵任一元素必然比num小，因此二分查找时找到的值比num小时，可以排除此区域，搜索[i, j]下方和右侧的子方阵
    代码解析：
        - 通过l和r的二分, up和down的二分逐步减小搜索区域
        - 终止条件是（1）无法再二分, 返回false（2）搜索到目标值，返回true
        - 减小搜索区域的策略见【题目分析】
*/

public class Solution {
    public boolean Find(int target, int [][] array) {
        return find(target, array, 0, array[0].length - 1, 0, array.length - 1);
    }
    
    public boolean find(int target, int [][] array, int l, int r, int up, int down){
        if(l > r || up > down) return false;
        int midCol = l + r >> 1, midRow = up + down >> 1;
        if(array[midRow][midCol] == target) return true;
        else if(array[midRow][midCol] > target){
            //搜素上方和左侧区域
            return find(target, array, l, midCol - 1, up, down) || find(target, array, l, r, up, midRow - 1);
        }
        else{
            //搜索下方和右侧区域
            return find(target, array, midCol + 1, r, up, down) || find(target, array, l, r, midRow + 1, down);
        }
    }
}
