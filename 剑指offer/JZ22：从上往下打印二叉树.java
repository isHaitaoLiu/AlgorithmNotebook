/*
    - 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    - 知识点：二叉树、广度优先搜索
    - 题目解析：
    - 代码解析：
        利用队列做广度优先搜索；
        每一层搜索之前，先记录队列总数size，依次将size数量的的元素出队（必须记录总数，因此出队的同时有元素入队）
        每出队一个元素，将其非空的左、右子节点入队
*/


public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                res.add(t.val);
                if(t.left != null) queue.offer(t.left);
                if(t.right != null) queue.offer(t.right);
            }
        }
        return res;
    }
}