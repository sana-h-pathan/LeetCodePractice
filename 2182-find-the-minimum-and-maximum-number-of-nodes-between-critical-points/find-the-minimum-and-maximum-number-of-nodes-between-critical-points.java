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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode curr=head.next;
        int[] result=new int[]{-1,-1};
        if(head.next.next==null)
            return result;
        ListNode fast=head.next.next;
        int firstIdx=0;
        int prevIdx=0;
        int idx=2;
        int minDistance=Integer.MAX_VALUE;
        while(fast!=null){
            if((curr.val>prev.val && curr.val>fast.val)||(curr.val<prev.val && curr.val<fast.val)){
                if(prevIdx==0){
                    prevIdx=idx;
                    firstIdx=idx;
                }else{
                    minDistance = Math.min(minDistance, idx - prevIdx);
                    prevIdx=idx;
                }
                
            }
            prev=curr;
            curr=fast;
            fast=fast.next;
            idx++;
        }
        if(minDistance!=Integer.MAX_VALUE){
            result[1]=prevIdx-firstIdx;
            result[0]=minDistance;
        } 
        return result;
    }
}