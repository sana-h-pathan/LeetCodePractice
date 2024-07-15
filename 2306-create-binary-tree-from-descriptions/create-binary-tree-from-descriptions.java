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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map=new HashMap<>();
        HashMap<Integer,Boolean> childMap=new HashMap<>();
        for(int[] d: descriptions){
            int parentVal=d[0];
            int childVal=d[1];
            int isLeft=d[2];
            if(!map.containsKey(parentVal))
                map.put(parentVal, new TreeNode(parentVal));
            if(!map.containsKey(childVal))
                map.put(childVal, new TreeNode(childVal));

            TreeNode pNode=map.get(parentVal);
            TreeNode cNode=map.get(childVal);
            if(isLeft==1)
                pNode.left=cNode;
            else
                pNode.right=cNode;
            
            childMap.put(childVal, true);
        }
        
        for(int[] d: descriptions){
            int parent=d[0];
            if(!childMap.containsKey(parent))
                return map.get(parent);
        }
        return null;
    }
}