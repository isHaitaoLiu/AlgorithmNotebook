/*
    - 题目描述：输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
              路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    - 知识点：二叉树、递归、回溯法
    - 题目解析：搜索每一条从根节点到叶子节点的路径，判断其和是否等于目标值target
              考虑从根开始的回溯，每次取根元素加入候选结果集合，如果发现候选集合之和等于目标值，且是叶子节点，则加入结果；
              如果不是叶子节点，继续搜索左子节点和右子节点；
              递归函数的末尾，还需要把当前根节点从候选集合中删除
    - 代码解析：
            说一下候选序列删除根节点的原因，如果不删除，考虑一个根有左右子树的情况，左子树搜索完成后，
            其所有节点都保存在候选集合中，右子树将无法完成正常搜索
*/



public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<>();
        if(root == null) return res;
        find(res, cur, root, target);
        return res;
    }
    
    public void find(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, TreeNode root, int target){
        cur.add(root.val);
        if(root.val == target && root.left == null && root.right == null){
            res.add(new ArrayList(cur));
        }
        else{
            if(root.left != null) find(res, cur, root.left, target - root.val); 
            if(root.right != null) find(res, cur, root.right, target - root.val);  //如果不弹出，这里发生错误
        }
        cur.remove(cur.size() - 1);
    }
}