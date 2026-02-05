/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode curr =  head;
        ListNode fast =  head.next;
        ListNode prev = null;
        
        while(fast!=null){
            curr.next = fast.next;
            fast.next = curr;
            if(prev!=null)
                prev.next = fast;
            
            if(curr.next == null)
                break;
             prev = curr;
            curr = curr.next;
            fast = curr.next;
           
        }
        
      return newHead;
    }
}