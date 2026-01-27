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
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] treeValue = data.split(",");
        int n = treeValue.length;
        int idx=0;
        TreeNode root = new TreeNode(Integer.parseInt(treeValue[idx++]));
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(idx<n && !treeValue[idx].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(treeValue[idx]));
                bfsQue.add(curr.left);
            }
            idx++;
            if(idx<n && !treeValue[idx].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(treeValue[idx]));
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