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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            l3 = l3.next;
        }
        while(l1!=null){
            l3.next = new ListNode(l1.val);
            l1 = l1.next;
            l3 = l3.next;
        }
        while(l2!=null){
            l3.next = new ListNode(l2.val);
            l2 = l2.next;
            l3 = l3.next;
        }
        return dummy.next;
    }
}