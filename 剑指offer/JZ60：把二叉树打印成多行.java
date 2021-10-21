/*
    - 题目描述：
        从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
        例如：
        给定的二叉树是{1,2,3,#,#,4,5}
    - 知识点：二叉树、队列
    - 题目解析：
        队列完成层序遍历
    - 代码解析：
*/

public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(pRoot);
        while(!dq.isEmpty()){
            int size = dq.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = dq.poll();
                tmp.add(cur.val);
                if(cur.left != null) dq.offer(cur.left);
                if(cur.right != null) dq.offer(cur.right);
            }
            res.add(tmp);
        }
        return res;
    }   
}