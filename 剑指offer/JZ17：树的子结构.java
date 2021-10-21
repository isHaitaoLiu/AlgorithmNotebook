/*
    - 题目描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    - 知识点：树、递归
    - 题目解析：
    - 代码解析：
        1. 如果root1 root2其中一个为null，说明必然不存在子结构关系，直接返回false；
        2. 检查root1代表的树是否与root2相似，这个相似关系要求root1有的节点，root2必须有且值一样
        3. 递归检查root1.left代表的树是否与root2有子结构关系;root2代表的树是否与root2有子结构关系
        4. 只要任意一个有子结构关系，即可返回true
*/



public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return check(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    
    public boolean check(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null) return false;
        if(root2 == null) return true;
        return root1.val == root2.val && check(root1.left, root2.left) && check(root1.right, root2.right);
    }
}