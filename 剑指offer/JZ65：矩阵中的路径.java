/*
    - 题目描述：
        请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
        每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
    - 知识点：深度优先搜索、回溯
    - 题目解析：
        深度优先搜索，碰到边界、与字符串不匹配、已经访问过的情况都直接返回false；
        如果当前索引已经和字符串长度一致，则表示完全匹配，可以直接返回， 否则需要进行上、下、左、右的搜索与回溯
    - 代码解析：
*/


public class Solution {
    public boolean hasPath (char[][] matrix, String word) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                boolean res = dfs(matrix, visited, j, i, 0, word);
                if(res == true) return res;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] matrix, boolean[][] visited, int curX, int curY, int idx, String word){
        if(curX < 0 || curY < 0 || 
           curX >= matrix[0].length || curY >= matrix.length || 
           visited[curY][curX] == true || 
           word.charAt(idx) != matrix[curY][curX])
            return false;
        else{
            boolean a, b, c, d;
            visited[curY][curX] = true;
            if(idx == word.length() - 1) return true;
            else{
                a = dfs(matrix, visited, curX + 1, curY, idx + 1, word);
                b = dfs(matrix, visited, curX - 1, curY, idx + 1, word);
                c = dfs(matrix, visited, curX, curY + 1, idx + 1, word);
                d = dfs(matrix, visited, curX, curY - 1, idx + 1, word);
            }
            visited[curY][curX] = false;
            return a || b || c || d;
        }
    }
}