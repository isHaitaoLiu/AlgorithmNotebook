/*
    - 题目描述：
        请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
    - 知识点：二叉树
    - 题目解析：
        递归判别左右子树的对称性即可
    - 代码解析：
*/



public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        return isSame(pRoot.left, pRoot.right);
    }
    
    boolean isSame(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null) return false;
        else return root1.val == root2.val && isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
    }
}