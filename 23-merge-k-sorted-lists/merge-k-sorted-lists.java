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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        for(ListNode li: lists){
            if(li!=null){
                pq.add(li);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(!pq.isEmpty()){
            ListNode currNode = pq.poll();
            result.next = currNode;
            result = result.next;
            if(currNode.next!=null){
                pq.add(currNode.next);
            }
        }
        return dummy.next;
    }
}