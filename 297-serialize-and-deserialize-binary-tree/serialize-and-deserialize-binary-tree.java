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
        StringBuilder sb=new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<TreeNode> bfsQue=new LinkedList<>();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr=bfsQue.poll();
            if(curr!=null){
                sb.append(curr.val);
                bfsQue.add(curr.left);
                bfsQue.add(curr.right);
            }else{
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] value=data.split(",");
        Queue<TreeNode> bfsQue=new LinkedList<>();
        int idx=1;
        TreeNode root= new TreeNode(Integer.parseInt(value[0]));
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr=bfsQue.poll();
            if(!value[idx].equals("#")){
                curr.left=new TreeNode(Integer.parseInt(value[idx]));
                bfsQue.add(curr.left);
            }
            idx++;
            if(!value[idx].equals("#")){
                curr.right=new TreeNode(Integer.parseInt(value[idx]));
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