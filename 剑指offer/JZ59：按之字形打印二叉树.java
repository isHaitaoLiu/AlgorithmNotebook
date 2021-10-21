/*
    - 题目描述：
        给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
        例如：
        给定的二叉树是{1,2,3,#,#,4,5}
    - 知识点：二叉树、队列
    - 题目解析：
        类似于层序遍历，用双端队列代替队列即可
    - 代码解析：
*/


public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(pRoot);
        boolean flag = false;
        while(!dq.isEmpty()){
            int size = dq.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = null;
                if(flag == true){
                    cur = dq.pollLast();
                    if(cur.right != null) dq.offerFirst(cur.right);
                    if(cur.left != null) dq.offerFirst(cur.left);
                }
                else{
                    cur = dq.pollFirst();
                    if(cur.left != null) dq.offerLast(cur.left);
                    if(cur.right != null) dq.offerLast(cur.right);
                }
                tmp.add(cur.val);
            }
            res.add(tmp);
            flag = !flag;
        }
        return res;
    }   
}