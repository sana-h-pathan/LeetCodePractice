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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        return depth(lca,p) + depth(lca,q);
    }
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private int depth(TreeNode root, int target) {
      Queue<TreeNode> bfsQue=new LinkedList<>();
        bfsQue.add(root);
        int level=0;
        while(!bfsQue.isEmpty()){
            int size=bfsQue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=bfsQue.poll();
                if(curr.val==target)
                   return level;
                if(curr.left!=null)
                    bfsQue.add(curr.left);
                if(curr.right!=null)
                    bfsQue.add(curr.right);
            }
            level++;
        }
        return level;
    }
}