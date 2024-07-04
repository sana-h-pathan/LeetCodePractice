/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr=head.next;
        ListNode newNode=new ListNode(0);
        head=newNode;
        boolean first=true;
        int sum=0;
        while(curr!=null){
            if(curr.val==0){
                if(first){
                    newNode.val=sum;
                    first=false;
                }
                else{
                    newNode.next=new ListNode(sum);
                    newNode=newNode.next;
                }
                sum=0;
            }else{
            sum+=curr.val;
            }
            curr=curr.next;
        }
        return head;
    }
}