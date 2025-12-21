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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        int carry=0;
        while(l1!=null || l2!=null){
            int l1Val = l1!=null?l1.val:0;
            int l2Val = l2!=null?l2.val:0;
            int sum = l1Val+l2Val+carry;
            l3.next = new ListNode(sum%10);
            carry = sum/10;
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
            l3=l3.next;
            if(carry>0){
                l3.next = new ListNode(carry);
            }
        }
        return dummy.next;
    }
}