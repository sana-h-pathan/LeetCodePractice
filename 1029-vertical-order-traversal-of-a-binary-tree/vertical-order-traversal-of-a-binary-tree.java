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
    static class NodeInfo {
        int col;
        int row;
        int val;
        NodeInfo(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> list = new ArrayList<>();
        helper(root, 0, 0, list);

        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (NodeInfo node : list) {
            if (node.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node.col;
            }
            result.get(result.size() - 1).add(node.val);
        }
        return result;
    }

    private void helper(TreeNode root, int col, int row, List<NodeInfo> list) {
        if (root == null) return;
        list.add(new NodeInfo(col, row, root.val));
        helper(root.left, col - 1, row + 1, list);
        helper(root.right, col + 1, row + 1, list);
    }
}
