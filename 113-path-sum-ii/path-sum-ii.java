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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(root,targetSum,result, new ArrayList<>());
        return result;
    }
    private void backtrack(TreeNode root, int target, List<List<Integer>> result, ArrayList<Integer> temp){
        if(root==null)
            return;
        target-=root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null){
            if(target==0){
                result.add(new ArrayList<>(temp));
            }
        }
        backtrack(root.left, target, result, temp);
        backtrack(root.right, target, result, temp);
        temp.remove(temp.size()-1);
    }
}