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
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            List<Integer> innerList = new ArrayList<>();
            int size = bfsQue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = bfsQue.poll();
                innerList.add(curr.val);
                if(curr.left!=null)
                    bfsQue.add(curr.left);
                if(curr.right!=null)
                    bfsQue.add(curr.right);
            }
            result.add(innerList);
        }
        return result;
    }
}