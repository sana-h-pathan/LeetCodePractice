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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverseSecondPart=reverse(slow.next);
        slow.next=null;
        slow=head;
        while(reverseSecondPart!=null){
            //1->2->3
            //5->4
            ListNode temp=slow.next;
            slow.next=reverseSecondPart;
            reverseSecondPart=reverseSecondPart.next;
            slow.next.next=temp;
            slow=temp;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode fast=head.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}