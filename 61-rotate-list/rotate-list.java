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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)
            return head;
        int count=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            count++;
        }
        
        k=k%count;
        int steps=count-k;
        ListNode newCurr=head;
        for(int i=1;i<steps;i++){
            newCurr=newCurr.next;
        }
        
        tail.next=head;
        ListNode newHead=newCurr.next;
        newCurr.next=null;
        return newHead;
    }
}