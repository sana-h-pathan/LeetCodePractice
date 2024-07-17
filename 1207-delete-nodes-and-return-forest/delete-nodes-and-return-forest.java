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
    HashSet<Integer> toDelete;
    List<TreeNode> result;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.toDelete=new HashSet<>();
        this.result=new ArrayList<>();
        for(int num: to_delete)
            toDelete.add(num);
        removeNodes(root);
        if(!toDelete.contains(root.val))
            result.add(root);

        return result;
    }
    private TreeNode removeNodes(TreeNode root){
        if(root==null)
            return null;
        
        root.left=removeNodes(root.left);
        root.right=removeNodes(root.right);
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