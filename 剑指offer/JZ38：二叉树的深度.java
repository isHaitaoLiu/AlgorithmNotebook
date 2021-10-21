/*
    - 题目描述：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    - 知识点：递归、二叉树
    - 题目解析：
        递归地计算左右子树，返回子树深度最大值，再加1，表示加上根节点的深度；
        递归出口是计算到叶子节点
    - 代码解析：
*/



public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}