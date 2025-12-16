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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> bfsQue = new LinkedList<>();
        Queue<Integer> colQue = new LinkedList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        bfsQue.add(root);
        colQue.add(0);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            int currCol = colQue.poll();
            min = Math.min(min, currCol);
            max = Math.max(max, currCol);
            if(!map.containsKey(currCol)){
                map.put(currCol, new ArrayList<>());
            }
            map.get(currCol).add(curr.val);
            if(curr.left!=null){
                bfsQue.add(curr.left);
                colQue.add(currCol-1);
            }
            if(curr.right!=null){
                bfsQue.add(curr.right);
                colQue.add(currCol+1);
            }
        }
        for(int i=min;i<=max;i++){
            result.add(map.get(i));
        }
        return result;
    }
}