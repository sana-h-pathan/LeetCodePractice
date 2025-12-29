/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        int hashCount=0;
        while(!bfsQue.isEmpty() && hashCount<bfsQue.size()){
            TreeNode curr = bfsQue.poll();
            if(curr!=null){
                sb.append(curr.val);
                if(curr.left==null){
                    hashCount++;
                }
                if(curr.right==null){
                    hashCount++;
                }
                bfsQue.add(curr.left);
                bfsQue.add(curr.right);
            }else{
                sb.append("#");
                hashCount--;
            }
            sb.append(",");
            
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] values = data.split(",");
        int idx=0;
        int rootValue = Integer.parseInt(values[idx]);
        TreeNode root = new TreeNode(rootValue);
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        idx++;
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(idx<values.length && !values[idx].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(values[idx]));
                bfsQue.add(curr.left);
            }
            idx++;
            if(idx<values.length && !values[idx].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(values[idx]));
                bfsQue.add(curr.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));