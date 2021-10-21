/*
    - 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    - 知识点：二叉树、二叉搜索树、双向链表
    - 题目解析：
    - 代码解析：
            类似于一个中序遍历的思路，先递归左子树，处理节点本身，再递归处理右子树
            在处理节点本身时，需要注意，如果pre为null，说明当前节点作为链表的头节点；
            如果pre不为null，则pre后继指针right指向自身，自身的前驱指针left指向pre，之后修改pre为自身即可
*/


public class Solution {
    TreeNode pre = null;
    TreeNode head = null;
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        
        if(pre == null){
            head = pRootOfTree;
            pre = pRootOfTree;
        }else{
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }
}