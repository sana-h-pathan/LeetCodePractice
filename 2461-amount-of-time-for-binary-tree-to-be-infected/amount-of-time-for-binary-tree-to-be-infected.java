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
    TreeNode target = null;
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        findParent(root, start, map);
        return findMaxDistance(map, target);
    }

    public void findParent(TreeNode root, int start, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        while (!bfsQue.isEmpty()) {
            TreeNode node = bfsQue.poll();
            if (node.val == start) 
                target = node;
            if (node.left != null) {
                map.put(node.left, node);
                bfsQue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                bfsQue.add(node.right);
            }
        }
    }

    public int findMaxDistance(Map<TreeNode, TreeNode> map, TreeNode target) {
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> bfsQue = new LinkedList<>();
        int count = -1;
        bfsQue.add(target);
        set.add(target);

        while (!bfsQue.isEmpty()) {
            int qSize = bfsQue.size();
            count++;

            for (int i = 0; i < qSize; i++) {
                TreeNode node = bfsQue.poll();

                if (node.left != null && !set.contains(node.left)) {
                    set.add(node.left);
                    bfsQue.add(node.left);
                }

                if (node.right != null && !set.contains(node.right)) {
                    set.add(node.right);
                    bfsQue.add(node.right);
                }

                if (map.get(node) != null && !set.contains(map.get(node))) {
                    set.add(map.get(node));
                    bfsQue.add(map.get(node));
                }
            }
        }
        return count;
    }
}