/*
    - 题目描述：操作给定的二叉树，将其变换为源二叉树的镜像。
    - 知识点：树、递归
    - 题目解析：
    - 代码解析：
        递归的交换左右子树即可。
*/



public class Solution {
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot != null){
            TreeNode temp = pRoot.left;
            pRoot.left = Mirror(pRoot.right);
            pRoot.right = Mirror(temp);
        }
        return pRoot;
    }
}