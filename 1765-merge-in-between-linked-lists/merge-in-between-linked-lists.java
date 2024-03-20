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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr=list1;
        a--;
        int diff=b-a;
        while(a!=0){
            curr=curr.next;
            a--;
        }
        ListNode tail=curr;
        while(diff!=0){
            tail=tail.next;
            diff--;
        }
        tail=tail.next;
        curr.next=list2;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=tail;

        return list1;
    }
}