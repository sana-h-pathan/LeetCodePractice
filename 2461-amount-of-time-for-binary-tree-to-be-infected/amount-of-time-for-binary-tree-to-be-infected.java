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
    TreeNode res; // Declare the 'res' variable here

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        TreeNode target = findParent(root, start, mpp);
        return findMaxDistance(mpp, target);
    }

    public TreeNode findParent(TreeNode root, int start, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == start) res = node;
            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
        return res;
    }

    // Change the parameter name from mpp to parent
    public int findMaxDistance(Map<TreeNode, TreeNode> parent, TreeNode target) {
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        int maxi = -1;
        q.add(target);
        set.add(target);

        while (!q.isEmpty()) {
            int qSize = q.size();
            maxi++;

            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !set.contains(node.left)) {
                    set.add(node.left);
                    q.add(node.left);
                }

                if (node.right != null && !set.contains(node.right)) {
                    set.add(node.right);
                    q.add(node.right);
                }

                if (parent.get(node) != null && !set.contains(parent.get(node))) {
                    set.add(parent.get(node));
                    q.add(parent.get(node));
                }
            }
        }
        return maxi;
    }
}