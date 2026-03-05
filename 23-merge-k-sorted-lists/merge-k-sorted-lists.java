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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode li: lists){
            if(li!=null){
                pq.add(li);
            }
        }
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }
}