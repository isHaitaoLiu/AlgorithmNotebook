/*
    - 题目描述：
        给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
        注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
        下图为一棵有9个节点的二叉树。树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
    - 知识点：二叉树
    - 题目解析：
        （1）有右子树，则右子树的最左侧节点为中序遍历下一个节点
        （2）无右子树，有父亲节点，且当前节点是父节点的左子节点。则父节点为中序遍历下一个节点
        （3）无右子树，有父亲节点，且当前节点是父节点的右子节点。则需要向上，一直找到当前节点是左子节点的树的根
    - 代码解析：
*/

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null){
            TreeLinkNode cur = pNode.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }else if(pNode.next != null){
            if(pNode == pNode.next.left)
                return pNode.next;
            else{
                while(pNode.next != null && pNode == pNode.next.right){
                    pNode = pNode.next;
                }
                return pNode.next;
            }
        }
        return null;
    }
}