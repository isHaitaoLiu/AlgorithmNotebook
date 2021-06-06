/*
    - 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    - 知识点：二叉树创建、二叉树遍历
    - 题目分析：
        - 熟悉二叉树三种遍历方式可轻松解答此题。
        - 某个树的前序遍历的结果中，根结点必然是第一个。去除第一个的前序遍历结果中，左半部分是左子树，右半部分是右子树。但分界点需要另行推导。
        - 某个树的中序遍历的结果中，根结点必然在中间，将左子树结果和右子树结果划分开来。
        - 因此，根据前序遍历结果可确定根节点, 在知晓根节点后，可根据中序遍历得到左右子树的节点数，即可解决谦虚遍历中，左右子树无法明确分界点的问题。
    - 代码分析
        - 递归进行树的构建，终止条件是遍历结果序列已经为空
        - 1. 通过前序遍历首节点拿到根结点值val，建立根节点
        - 2. 在中序遍历中搜索根结点值val的位置
        - 3. 根据中序遍历根结点位置，得到左子树和右子树的节点个数
        - 4. 递归进行左子树和右子树的构建
*/



public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    
    public static TreeNode construct(int[] pre, int lp, int rp, int[] in, int li, int ri){
        if(lp > rp || li > ri) return null;
        int val = pre[lp];
        TreeNode root = new TreeNode(val);
        int idx = li;
        while(in[idx] != val){
            idx++;
        }
        root.left = construct(pre, lp + 1, lp + idx - li, in, li, idx - 1);
        root.right = construct(pre, lp + idx - li + 1, rp, in, idx + 1, ri);
        return root;
    }
}