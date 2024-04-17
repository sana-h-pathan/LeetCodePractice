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
        // Initialize the smallest string to store the result
        String smallestString = "";
        // Create a queue to perform BFS traversal
        Queue<List<Object>> bfsQueue = new LinkedList<>();
        // Convert the value of the root node to a string and add it to the queue along with the root node
        String val = String.valueOf((char) (root.val + 'a'));
        bfsQueue.add(Arrays.asList(root, val));

        // Perform BFS traversal
        while (!bfsQueue.isEmpty()) {
            // Dequeue an entry from the queue containing the current node and its corresponding string
            List<Object> entry = bfsQueue.poll();
            TreeNode curr = (TreeNode) entry.get(0); // Get the current node
            String currentString = (String) entry.get(1); // Get the current string

            // Check if the current node is a leaf node
            if (curr.left == null && curr.right == null) {
                // If smallestString is empty, set it to the current string
                // If the current string is lexicographically smaller than smallestString, update smallestString
                if (smallestString.isEmpty()) {
                    smallestString = currentString;
                } else if (currentString.compareTo(smallestString) < 0) {
                    smallestString = currentString;
                }
            }

            // Enqueue the left child of the current node along with its corresponding string
            if (curr.left != null) {
                String currStr = (char) (curr.left.val + 'a') + currentString; // Concatenate the current character
                bfsQueue.add(Arrays.asList(curr.left, currStr));
            }

            // Enqueue the right child of the current node along with its corresponding string
            if (curr.right != null) {
                String currStr = (char) (curr.right.val + 'a') + currentString; // Concatenate the current character
                bfsQueue.add(Arrays.asList(curr.right, currStr));
            }
        }

        // Return the smallest lexicographically string obtained
        return smallestString;
    }
}
