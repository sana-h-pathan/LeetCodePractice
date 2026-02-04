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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left!=null){
                bfsQue.add(curr.left);
            }
            if(curr.right!=null){
                bfsQue.add(curr.right);
            }
        }
        return root;
    }
}