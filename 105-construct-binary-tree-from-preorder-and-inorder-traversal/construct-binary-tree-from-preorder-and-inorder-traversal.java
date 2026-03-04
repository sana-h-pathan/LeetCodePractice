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
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++){
            inOrderMap.put(inorder[i], i);
        }
        return helper(preorder, inOrderMap, 0, n-1);
    }
    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int start, int end){
        if(start>end){
            return null;
        }
        int rootVal = preorder[idx++];
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, map, start, rootIdx-1);
        root.right = helper(preorder, map, rootIdx+1, end);
        return root;
    }
}