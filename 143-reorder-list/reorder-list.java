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
        if(head==null || head.next==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverse = reverseNode(slow.next);
        slow.next = null;
        slow=head;
        while(reverse!=null){
            ListNode temp = slow.next;
            slow.next = reverse;
            reverse = reverse.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverseNode(ListNode head){
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}