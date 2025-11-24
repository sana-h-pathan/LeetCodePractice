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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Integer.max(left, right);
    }
    public int maxDepth2(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> bfsQue=new LinkedList<>();
        bfsQue.add(root);
        int depth=0;
        while(!bfsQue.isEmpty()){
            int size=bfsQue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=bfsQue.poll();
                if(curr.left!=null)
                    bfsQue.add(curr.left);
                if(curr.right!=null)
                    bfsQue.add(curr.right);
            }
            depth++;
        }
        return depth;
    }
}