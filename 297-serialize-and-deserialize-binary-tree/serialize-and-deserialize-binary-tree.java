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
        bfsQue.add(root);
        StringBuilder sb = new StringBuilder();
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
        if(data==null || data.length()==0){
            return null;
        }
        String[] nodeVal = data.split(",");
        Queue<TreeNode> bfsQue = new LinkedList<>();
        int idx=0;
        int rootVal = Integer.parseInt(nodeVal[idx++]);
        TreeNode root = new TreeNode(rootVal);
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(idx<nodeVal.length && !nodeVal[idx].equals("#")){
                int leftVal = Integer.parseInt(nodeVal[idx]);
                curr.left = new TreeNode(leftVal);
                bfsQue.add(curr.left);
            }
            idx++;
            if(idx<nodeVal.length && !nodeVal[idx].equals("#")){
                int rightVal = Integer.parseInt(nodeVal[idx]);
                curr.right = new TreeNode(rightVal);
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