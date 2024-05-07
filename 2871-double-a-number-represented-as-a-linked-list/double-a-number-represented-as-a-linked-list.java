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
    public ListNode doubleIt(ListNode head) {
        ListNode dummy=head;
        ListNode prev=null;
        int carry=0;
        while(dummy!=null){
            int curr=dummy.val;
            
            int sum=curr*2;
            if (sum < 10) 
                dummy.val=sum;
            else if(prev!=null){
                dummy.val=sum%10;
                prev.val=prev.val+1;
            }
            else{
                head=new ListNode(1,dummy);
                dummy.val=sum%10;

            }
            prev=dummy;
            dummy=dummy.next;
        }
        return head;
    }
}