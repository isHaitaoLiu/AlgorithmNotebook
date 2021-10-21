/*
    - 题目描述：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
              有效括号组合需满足：左括号必须以正确的顺序闭合。
    - 知识点：回溯
    - 题目解析：
        生成有效的括号有两个准则（1）左括号数量不可大于n (2)子串中右括号数量不可大于左括号。
        满足这两个准则即可，放置左括号或者右括号。回溯即可解决。
    - 代码解析：
*/


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    public void backtrack(StringBuilder cur, int lNum, int rNum, int n, List<String> res){
        if(lNum == n && rNum == n){
            res.add(cur.toString());
        }else{
            if(lNum < n){
                cur.append('(');
                backtrack(cur, lNum + 1, rNum, n, res);
                cur.deleteCharAt(cur.length() - 1);
            }
            if(rNum < lNum){
                cur.append(')');
                backtrack(cur, lNum, rNum + 1, n, res);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}