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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null)
            return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverseList=reverse(slow);
        slow.next=null;
        slow=head;

        while(slow!=null && reverseList!=null){
            if(slow.val!=reverseList.val)
                return false;
            slow=slow.next;
            reverseList=reverseList.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        if(head==null)
            return head;
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