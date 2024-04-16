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
    public TreeNode addOneRow(TreeNode head, int val, int depth) {
        if (depth == 1) {
            TreeNode root = new TreeNode(val);
            root.left = head;
            return root;
        }
        TreeNode root = head;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                if(level==depth-2){
                    TreeNode leftTree = curr.left;
                    TreeNode rightTree = curr.right;
                    curr.left = new TreeNode(val);
                    curr.left.left = leftTree;
                    curr.left.right=null;
                    curr.right = new TreeNode(val);
                    curr.right.right = rightTree;
                    curr.right.left=null;
                }
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            if(level==depth-2)
                break;
            level++;
        }
        return head;
    }
}