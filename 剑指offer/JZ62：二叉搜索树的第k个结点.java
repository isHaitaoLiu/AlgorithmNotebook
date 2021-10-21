/*
    - 题目描述：
        给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
    - 知识点：二叉树
    - 题目解析：
        （1）法一，用ArrayList记录二叉树的中序遍历序列，返回第k个
        （2）法二，进行递归的中序遍历，用全局变量记录当前访问序号，用全局引用记录序号为k个的结点
    - 代码解析：
*/


public class Solution {
    TreeNode res = null;
    int idx = 0;
    
    TreeNode KthNode(TreeNode pRoot, int k) {
        this.res = null;
        this.idx = 0;
        inOrder(pRoot, k);
        return res;
    }

    public void inOrder(TreeNode pRoot, int k){
        if(pRoot == null) return;
        inOrder(pRoot.left, k);
        idx++;
        if(idx == k){
            res = pRoot;
        }
        inOrder(pRoot.right, k);
    }
}