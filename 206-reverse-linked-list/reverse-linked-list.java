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
    public ListNode reverseList(ListNode head) {
        // If the head is null, there's nothing to reverse, so return null
        if(head==null)
            return null;
        
        // Initialize pointers for previous, current, and fast (next node)
        ListNode prev=null; // Initially set to null as there is no previous node
        ListNode curr=head; // Start from the head of the list
        ListNode fast=head.next; // Points to the node after current
        
        // Traverse the list and reverse the pointers
        while(fast!=null){
            curr.next=prev; // Reverse the current node's pointer to the previous node
            prev=curr; // Move prev pointer to the current node
            curr=fast; // Move curr pointer to the next node
            fast=fast.next; // Move fast pointer to the next node
        }
        
        // Handle the last node whose next pointer should point to the previous node
        curr.next=prev; // Reverse the pointer of the last node
        
        // At this point, curr points to the last node, which is now the head of the reversed list
        return curr; // Return the head of the reversed list
    }
}