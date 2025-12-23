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
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> toDelete =new HashSet<>();
        List<TreeNode> result=new ArrayList<>();
        for(int num: to_delete)
            toDelete.add(num);
        removeNodes(root, toDelete, result);
        if(!toDelete.contains(root.val))
            result.add(root);

        return result;
    }
    private TreeNode removeNodes(TreeNode root, HashSet<Integer> toDelete, List<TreeNode> result){
        if(root==null)
            return null;
        
        root.left=removeNodes(root.left, toDelete, result);
        root.right=removeNodes(root.right, toDelete, result);
        if(toDelete.contains(root.val)){
            if(root.left!=null)
                result.add(root.left);
            if(root.right!=null)
                result.add(root.right);
            return null;
        }
        return root;

    }
}