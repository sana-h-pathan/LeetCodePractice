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
    StringBuilder sb=new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> bfsQue=new LinkedList<>();
        bfsQue.add(root);
        sb.append(root.val).append(",");
        while(!bfsQue.isEmpty()){
            TreeNode curr=bfsQue.poll();
            if(curr.left!=null){
                bfsQue.add(curr.left);
                sb.append(curr.left.val).append(",");
            }
            else
                sb.append("#,");
            if(curr.right!=null){
                bfsQue.add(curr.right);
                sb.append(curr.right.val).append(",");
            }
            else
                sb.append("#,");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] value=data.split(",");
        ArrayList<String> treeVal = new ArrayList<>(Arrays.asList(value));
        int idx=0;
        Queue<TreeNode> bfsQue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(treeVal.get(idx)));
        bfsQue.add(root);
        idx++;
        while(!bfsQue.isEmpty()){
            TreeNode curr=bfsQue.poll();
            if (!treeVal.get(idx).equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(treeVal.get(idx)));
                curr.left = leftNode;
                bfsQue.offer(leftNode);
            }
            idx++;
            if (!treeVal.get(idx).equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(treeVal.get(idx)));
                curr.right = rightNode;
                bfsQue.offer(rightNode);
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