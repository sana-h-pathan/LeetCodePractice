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
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        return helper(preorder,map,0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder, HashMap<Integer,Integer> map, int low, int high){
        if(low>high)
            return null;

        int rootVal=preorder[idx++];
        TreeNode root=new TreeNode(rootVal);
        int rootIdx=map.get(rootVal);
        root.left=helper(preorder, map, low, rootIdx-1);
        root.right=helper(preorder, map, rootIdx+1, high);

        return root;
    }
}