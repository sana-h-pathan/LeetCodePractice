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
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverseList = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(reverseList!=null){
            ListNode temp = slow.next;
            slow.next = reverseList;
            reverseList = reverseList.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
    private ListNode reverse(ListNode head){
        if(head==null|| head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next=prev;
        return curr;
    }
}