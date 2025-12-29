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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            int maxVal = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr = bfsQue.poll();
                maxVal = Math.max(curr.val, maxVal);
                if(curr.left!=null){
                    bfsQue.add(curr.left);
                }
                if(curr.right!=null){
                    bfsQue.add(curr.right);
                }
            }
            result.add(maxVal);
        }
        return result;
    }
}