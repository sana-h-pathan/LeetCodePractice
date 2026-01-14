/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cntA = 0;
        int cntB = 0;
        ListNode dummy = headA;
        while(dummy!=null){
            cntA++;
            dummy = dummy.next;
        }
        dummy = headB;
        while(dummy!=null){
            cntB++;
            dummy = dummy.next;
        }
        while(cntA>cntB){
            headA= headA.next;
            cntA--;
        }
        while(cntB>cntA){
            headB= headB.next;
            cntB--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}