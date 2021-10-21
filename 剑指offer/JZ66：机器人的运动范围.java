/*
    - 题目描述：
        地上有一个rows行和cols列的方格。坐标从 [0,0] 到 [rows-1,cols-1]。一个机器人从坐标0,0的格子开始移动，
        每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于threshold的格子。 
        例如，当threshold为18时，机器人能够进入方格[35,37]，因为3+5+3+7 = 18。但是，它不能进入方格[35,38]，
        因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

    - 知识点：深度优先搜索、回溯
    - 题目解析：
        深度优先搜索，碰到边界、触碰极限、已经访问过的情况都直接返回；
        否则进行上、下、左、右的搜索与回溯，累加结果
    - 代码解析：
*/

public class Solution {
    int res = 0;
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        dfs(visited, 0, 0, rows, cols, threshold);
        return res;
    }
    
    public void dfs(boolean[][] visited, int row, int col, int rows, int cols, int threshold){
        if(row < 0 || col < 0 || row >= rows || col >= cols || 
           check(row, col, threshold) == false || visited[row][col] == true){
            return;
        }
        else{
            visited[row][col] = true;
            res++;
            
            dfs(visited, row + 1, col, rows, cols, threshold);
            dfs(visited, row - 1, col, rows, cols, threshold);
            dfs(visited, row, col + 1, rows, cols, threshold);
            dfs(visited, row, col - 1, rows, cols, threshold);
        }
    }
    
    public boolean check(int row, int col, int threshold){
        int counter = 0;
        while(row > 0){
            counter += row % 10;
            row = row / 10;
        }
        while(col > 0){
            counter += col % 10;
            col = col / 10;
        }
        if(counter <= threshold) return true;
        else return false;
    }
}