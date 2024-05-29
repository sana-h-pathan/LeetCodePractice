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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> bfsQue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        int count=0;
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            int size=bfsQue.size();
            List<Integer> subList = new ArrayList<>(Collections.nCopies(size, 0));
            for(int i=0;i<size;i++){
                TreeNode curr=bfsQue.poll();
                int index = count % 2 == 0 ? i : (size - 1 - i);
                subList.set(index, curr.val);              
                if(curr.left!=null)
                    bfsQue.add(curr.left);
                if(curr.right!=null)
                    bfsQue.add(curr.right);
            }
            count++;
            result.add(subList);
        }
        return result;
    }
}