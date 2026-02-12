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
        Queue<TreeNode> bfsQue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(curr.left!=null){
                parentMap.put(curr.left, curr);
                bfsQue.add(curr.left);
            }
            if(curr.right!=null){
                parentMap.put(curr.right, curr);
                bfsQue.add(curr.right);
            }
        }
        bfsQue.add(target);
        while(k>0 && !bfsQue.isEmpty()){
            int size=bfsQue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = bfsQue.poll();
                visited.add(curr);
                if(curr.left!=null && !visited.contains(curr.left)){
                    bfsQue.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    bfsQue.add(curr.right);
                }
                if(parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))){
                    bfsQue.add(parentMap.get(curr));
                }
            }
            k--;
        }
        while(!bfsQue.isEmpty()){
            result.add(bfsQue.poll().val);
        }
        return result;
    }
}