/*
    - 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
              在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
              平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
              并且左右两个子树都是一棵平衡二叉树。
    - 知识点：二叉树
    - 题目解析：
            考虑平衡二叉树的条件，只要左右子树深度差超过1，则不是平衡二叉树，那么必须有一个方式计算二叉树的深度，
            这个计算二叉树深度的方式很简单，递归计算即可：Math.max(depth(root.left), depth(root.right)) + 1;
            如此一来二叉树深度必然为一个正值或0，我没可以设置一个特殊值，例如-1，来表示二叉树左右子树深度差超过1了
            如果上层节点收到-1的结果，则表示整颗树不可能平衡，直接也向上层节点返回-1，这样-1就可以层层上报到根节点了
    - 代码解析：
*/



public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) == -1 ? false : true;
    }
    
    public int depth(TreeNode root){
        if(root == null) return 0;
        int depl = depth(root.left);
        if(depl == -1) return -1;
        int depr = depth(root.right);
        if(depr == -1) return -1;
        int dev = Math.abs(depl - depr);
        if(dev > 1) return -1;
        return Math.max(depl, depr) + 1;
    }
}