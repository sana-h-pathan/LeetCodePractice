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
    
    int sum = 0;
    public int countPairs(TreeNode root, int distance) {
        traverseNode(root, distance);
        return sum;
    }
    
    private List<Integer> traverseNode(TreeNode root, int distance){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;

        List<Integer> left = traverseNode(root.left, distance);
        List<Integer> right = traverseNode(root.right, distance);

        if(left.isEmpty() && right.isEmpty()){
            list.add(1);
            return list;
        }

        if(!left.isEmpty() && !right.isEmpty()){
            for(Integer l : left){
                for(Integer r : right){
                    if(l + r <= distance) sum++;
                }
            }
        }

        for(Integer l : left){
            list.add(l + 1);
        }

        for(Integer r : right){
            list.add(r + 1);
        }

        return list;
    }
}