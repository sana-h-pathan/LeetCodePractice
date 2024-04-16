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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> bfsQueue=new LinkedList<>();
        bfsQueue.add(root);
        while(!bfsQueue.isEmpty()){
            TreeNode curr=bfsQueue.poll();
            if(curr.left!=null && curr.right==null)
                result.add(curr.left.val);
            if(curr.right!=null && curr.left==null)
                result.add(curr.right.val);
            if(curr.left!=null)
                bfsQueue.add(curr.left);
            if(curr.right!=null)
                bfsQueue.add(curr.right);
        }
        return result;
    }
}