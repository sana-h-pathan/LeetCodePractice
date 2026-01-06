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
        Queue<TreeNode> bfsQue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(curr!=null){
                sb.append(curr.val);
                bfsQue.add(curr.left);
                bfsQue.add(curr.right);
            } else {
                sb.append("#");
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
        int idx=0;
        String[] dataVal = data.split(",");
        Queue<TreeNode> bfsQue = new LinkedList<>();
        int rootVal = Integer.parseInt(dataVal[idx++]);
        TreeNode root = new TreeNode(rootVal);
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(!dataVal[idx].equals("#")){
                int left = Integer.parseInt(dataVal[idx]);
                curr.left = new TreeNode(left);
                bfsQue.add(curr.left);
            }
            idx++;
            if(!dataVal[idx].equals("#")){
                int right = Integer.parseInt(dataVal[idx]);
                curr.right = new TreeNode(right);
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