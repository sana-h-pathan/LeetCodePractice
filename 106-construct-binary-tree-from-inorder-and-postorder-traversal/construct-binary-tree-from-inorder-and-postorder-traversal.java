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
        HashMap<Integer,Integer> inOrderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i], i);
        }
        return helper(postorder,inOrderMap,0,postorder.length-1);
    }
    private TreeNode helper(int[] postorder, HashMap<Integer,Integer> map,int low, int high){
        if(low>high)
            return null;
        int rootVal=postorder[idx--];
        TreeNode root=new TreeNode(rootVal);
        int rootIdx=map.get(rootVal);
        root.right=helper(postorder, map, rootIdx+1, high);
        root.left=helper(postorder, map, low, rootIdx-1);

        return root;
    }
}