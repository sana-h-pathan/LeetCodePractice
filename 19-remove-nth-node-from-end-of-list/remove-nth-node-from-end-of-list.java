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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Defensive check
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast n steps ahead safely
        for (int i = 0; i < n; i++) {
            if (fast == null) return head;   // n is larger than length
            fast = fast.next;
        }

        // If fast is null here, n == length -> remove head
        if (fast == null) {
            return head.next;
        }

        // Move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete target node
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

}