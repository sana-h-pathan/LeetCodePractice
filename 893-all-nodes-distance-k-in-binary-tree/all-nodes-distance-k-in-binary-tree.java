/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);

        while (!bfsQue.isEmpty()) {
            int size = bfsQue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = bfsQue.poll();
                if (curr.left != null) {
                    map.put(curr.left.val, curr);
                    bfsQue.add(curr.left);
                }
                if (curr.right != null) {
                    map.put(curr.right.val, curr);
                    bfsQue.add(curr.right);
                }
            }
        }

        Map<Integer, Integer> visited = new HashMap<>();
        bfsQue.add(target);
        while (k > 0 && !bfsQue.isEmpty()) {
            int size = bfsQue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = bfsQue.poll();
                visited.put(curr.val, 1);
                if (curr.left != null && !visited.containsKey(curr.left.val)) {
                    bfsQue.offer(curr.left);
                }
                if (curr.right != null && !visited.containsKey(curr.right.val)) {
                    bfsQue.offer(curr.right);
                }
                if (map.containsKey(curr.val) && !visited.containsKey(map.get(curr.val).val)) {
                    bfsQue.offer(map.get(curr.val));
                }
            }
            k--;
        }

        while (!bfsQue.isEmpty()) {
            result.add(bfsQue.poll().val);
        }
        return result;
    }
}