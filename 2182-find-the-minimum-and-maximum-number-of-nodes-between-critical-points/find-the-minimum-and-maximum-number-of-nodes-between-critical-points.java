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
        ArrayList<Integer> list=new ArrayList<>();
        int idx=2;
        while(fast!=null){
            if((curr.val>prev.val && curr.val>fast.val)||(curr.val<prev.val && curr.val<fast.val)){
                list.add(idx);
            }
            prev=curr;
            curr=fast;
            fast=fast.next;
            idx++;
        }
        if(list.size()>1){
            int high=list.size()-1;
            result[1]=list.get(high)-list.get(0);
            result[0]=list.get(1)-list.get(0);
            for(int i=1;i<=high;i++){
                result[0]=Math.min(result[0], list.get(i)-list.get(i-1));
            }
        }

        return result;
    }
}