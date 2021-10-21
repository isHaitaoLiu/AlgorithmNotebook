/*
    - 题目描述：给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
              注：本题保证二叉树中每个节点的val值均不相同。
    - 知识点：二叉树
    - 题目解析： 
            三种情况（1）根节点匹配某个待查找节点，则根节点必然是最近公共祖先，直接返回；（2）待查找节点分散在左右两侧，则根节点必然是最近公共祖先，返回root；
                  （3）待查找节点都分配在根节点的其中一颗子树上，则进行递归查找。
    - 代码解析： 
*/

public class Solution {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return dfs(root, o1, o2).val;
    }
    
    public TreeNode dfs(TreeNode root, int o1, int o2){
        if(root == null || root.val == o1 || root.val == o2) return root;
        
        TreeNode l = dfs(root.left, o1, o2);
        TreeNode r = dfs(root.right, o1, o2);
        if(l == null) return r;
        if(r == null) return l;
        return root;
    }
}