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
    public ListNode mergeInBetween(ListNode list1, int start, int end, ListNode list2) {
        ListNode head = list1; // Pointer to traverse list1
        // Move 'current' pointer to the node before the sublist to be replaced
        for (int i = 1; i < start; i++) {
            head = head.next;
        }
        ListNode tail = head; // Pointer to mark the end of the sublist to be replaced
        // Move 'sublistEnd' pointer to the node after the sublist to be replaced
        for (int i = 0; i <=end - start + 1; i++) {
            tail = tail.next;
        }
        head.next = list2; // Connect the last node before the sublist to list2
        // Move 'current' pointer to the end of list2
        while (head.next != null) {
            head = head.next;
        }
        head.next = tail; // Connect the end of list2 to the node after the sublist
        return list1; // Return the modified list1
    }
}