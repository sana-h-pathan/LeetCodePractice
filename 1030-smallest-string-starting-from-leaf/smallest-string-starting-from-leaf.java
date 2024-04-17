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
    public String smallestFromLeaf(TreeNode root) {
        String smallestString = "";
        Queue<Pair<TreeNode, String>> bfsQue = new LinkedList<>();
        String val=String.valueOf((char)(root.val + 'a'));
        bfsQue.add(new Pair<>(root, val));

        while (!bfsQue.isEmpty()) {
            Pair<TreeNode, String> pair = bfsQue.poll();
            TreeNode curr = pair.getKey();
            String currentString = pair.getValue();
            if (curr.left == null && curr.right == null) {
                if (smallestString.isEmpty()) {
                    smallestString = currentString;
                } else if(currentString.compareTo(smallestString) < 0)
                        smallestString =  currentString;
            }
            if (curr.left != null) {
                String currStr=(char)(curr.left.val + 'a') + currentString;
                bfsQue.add(new Pair<>(curr.left, currStr));
            }

            if (curr.right != null) {
                String currStr=(char)(curr.right.val + 'a') + currentString;
                bfsQue.add(new Pair<>(curr.right, currStr));
            }
        }
        return smallestString;
    }
}