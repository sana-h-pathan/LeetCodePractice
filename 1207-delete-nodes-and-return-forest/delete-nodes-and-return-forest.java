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
        HashSet<Integer> set = new HashSet<>();
        for(int num: to_delete){
            set.add(num);
        }
        List<TreeNode> result= new ArrayList<>();
        helper(root, set, result);
        if(!set.contains(root.val)){
            result.add(root);
        }
        return result;
    }
    private TreeNode helper(TreeNode root, HashSet<Integer> set, List<TreeNode> result){
        if(root==null)
            return null;
        root.left = helper(root.left, set, result);
        root.right = helper(root.right, set, result);
        if(set.contains(root.val)){
            if(root.left!=null){
                result.add(root.left);
            }
            if(root.right!=null){
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
}