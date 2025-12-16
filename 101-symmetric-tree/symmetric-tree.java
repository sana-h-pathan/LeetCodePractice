/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root.left);
        bfsQue.add(root.right);
        while(!bfsQue.isEmpty()){
            TreeNode right = bfsQue.poll();
            TreeNode left = bfsQue.poll();
            if(left==null && right == null)
                continue;
            if(left==null || right==null)
                return false;
            if(left.val!=right.val){
                return false;
            }
            bfsQue.add(left.left);
            bfsQue.add(right.right);
            bfsQue.add(left.right);
            bfsQue.add(right.left);
        }
        return true;
    }
}