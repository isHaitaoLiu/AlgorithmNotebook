/*
    - 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
    - 知识点：深度优先搜索
    - 题目解析：螺旋打印矩阵
    - 代码解析：
        设置一个方向数组，依次为 向右、向下、向左、向上，设置一个方向索引idx，每次到达尽头则（idx + 1）mod 4 进行方向调整；
        设置一个已访问数组，标记已经访问过的位置；
        大循环迭代 m * n 次
        从[0][0]开始循环，沿着给定方向扫描，到达尽头(越界)或者已经访问过，则改换方向
*/




public class Solution {
    int[][] arrow = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int curX = 0, curY = 0;
        int idx = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix[0].length, n = matrix.length;
        boolean[][] visited = new boolean[n][m];
        int mn = m * n;
        while(mn > 0){
            visited[curY][curX] = true;
            res.add(matrix[curY][curX]);
            if(curX + arrow[idx][1] >= m 
               || curY + arrow[idx][0] >= n
               || curX + arrow[idx][1] < 0 
               || curY + arrow[idx][0] < 0
               || visited[curY + arrow[idx][0]][curX + arrow[idx][1]] == true){
                idx = (idx + 1) % 4;
            }
            curX = curX + arrow[idx][1];
            curY = curY + arrow[idx][0];
            mn--;
        }
        return res;
    }
}