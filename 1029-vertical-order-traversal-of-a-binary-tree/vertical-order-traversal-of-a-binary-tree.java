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
    class NodePosition {
        TreeNode node;
        int col, row;

        NodePosition(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<NodePosition>> map = new HashMap<>();
        Queue<NodePosition> bfsQueue = new LinkedList<>();
        bfsQueue.add(new NodePosition(root, 0, 0));

        while (!bfsQueue.isEmpty()) {
            NodePosition nodePos = bfsQueue.poll();
            TreeNode curr = nodePos.node;
            int col = nodePos.col;
            int row = nodePos.row;
            min = Math.min(min, col);
            max = Math.max(max, col);

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(nodePos);

            if (curr.left != null) {
                bfsQueue.add(new NodePosition(curr.left, col - 1, row + 1));
            }
            if (curr.right != null) {
                bfsQueue.add(new NodePosition(curr.right, col + 1, row + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            List<NodePosition> nodePositions = map.get(i);
            nodePositions.sort((a, b) -> {
                if (a.row != b.row) {
                    return Integer.compare(a.row, b.row);
                } else {
                    return Integer.compare(a.node.val, b.node.val);
                }
            });
            List<Integer> column = new ArrayList<>();
            for (NodePosition nodePos : nodePositions) {
                column.add(nodePos.node.val);
            }
            result.add(column);
        }
        return result;
    }
}