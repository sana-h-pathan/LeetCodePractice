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
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p==null && q!=null)||(p!=null && q==null))
            return false;
        if(p.val!=q.val)
            return false;
        return (isSameTree(p.left, q.left) && (isSameTree(p.right, q.right)));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p==null && q!=null)||(p!=null && q==null))
            return false;
        Queue<TreeNode> pQue=new LinkedList<>();
        Queue<TreeNode> qQue=new LinkedList<>();
        pQue.add(p);
        qQue.add(q);
        while(!pQue.isEmpty() && !qQue.isEmpty()){
            TreeNode pCurr=pQue.poll();
            TreeNode qCurr=qQue.poll();
            if(pCurr.val!=qCurr.val)
                return false;
            if((pCurr.left!=null && qCurr.left==null) || (pCurr.left==null && qCurr.left!=null))
                return false;
            if(pCurr.left!=null && qCurr.left!=null){
                pQue.add(pCurr.left);
                qQue.add(qCurr.left);
            }
            
            if((pCurr.right!=null && qCurr.right==null) || (pCurr.right==null && qCurr.right!=null))
                return false;
            if(pCurr.right!=null && qCurr.right!=null){
                pQue.add(pCurr.right);
                qQue.add(qCurr.right);
            }
        }
        return true;
    }
}