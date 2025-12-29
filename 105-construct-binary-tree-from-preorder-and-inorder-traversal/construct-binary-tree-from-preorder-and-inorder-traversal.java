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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorderMap, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> inorder, int start, int end){
        if(start>end){
            return null;
        }
        int rootVal = preorder[idx];
        int rootIdx = inorder.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        idx++;
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);

        return root;
    }
}