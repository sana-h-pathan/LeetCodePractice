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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = bfsQue.poll();
                subList.add(curr.val);
                if(curr.left!=null){
                    bfsQue.add(curr.left);
                }
                if(curr.right!=null){
                    bfsQue.add(curr.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}