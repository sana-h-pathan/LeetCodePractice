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
    public ListNode plusOne(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode reverseList = reverse(head);
        ListNode curr = reverseList;
        int carry=1;
        while(curr!=null && carry>0){
            int sum = curr.val+carry;
            curr.val = sum%10;
            carry = sum/10;
            if(curr.next==null && carry>0){
                curr.next = new ListNode(carry);
                carry=0;
            }
            curr = curr.next;
        }

        return reverse(reverseList);

    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
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