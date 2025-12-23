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
        return countTime(map);
    }

    private void findParent(TreeNode root, int start, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(curr.left!=null){
                map.put(curr.left, curr);
                bfsQue.add(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right, curr);
                bfsQue.add(curr.right);
            }
            if(curr.val==start){
                target=curr;
            }
        }
    }
    private int countTime(HashMap<TreeNode, TreeNode> map){
        int count=-1;
        Queue<TreeNode> bfsQue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        bfsQue.add(target);
        set.add(target);
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            count++;
            for(int i=0;i<size;i++){
                TreeNode curr = bfsQue.poll();
                if(curr.left!=null && !set.contains(curr.left)){
                    bfsQue.add(curr.left);
                    set.add(curr.left);
                }
                if(curr.right!=null && !set.contains(curr.right)){
                    bfsQue.add(curr.right);
                    set.add(curr.right);
                }
                if(map.containsKey(curr) && !set.contains(map.get(curr))){
                    bfsQue.add(map.get(curr));
                    set.add(map.get(curr));
                }
            }
        }
        return count;
    }
}