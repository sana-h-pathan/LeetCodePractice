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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val, b.val));
        for(ListNode li: lists){
            if(li!=null){
                pq.add(li);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            currNode.next = minNode;
            currNode = currNode.next;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }
}