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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.idx=postorder.length-1;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        return helper(postorder,0,inorder.length-1,map);   
    }
    private TreeNode helper(int[] postorder,int low, int high, HashMap<Integer, Integer> map){
        if(low>high)
            return null;
        int rootVal=postorder[idx--];
        TreeNode root=new TreeNode(rootVal);
        int rootIdx=map.get(rootVal);
        root.right = helper(postorder, rootIdx + 1, high, map);
        root.left = helper(postorder, low, rootIdx - 1, map);

        return root;
    }
    
}