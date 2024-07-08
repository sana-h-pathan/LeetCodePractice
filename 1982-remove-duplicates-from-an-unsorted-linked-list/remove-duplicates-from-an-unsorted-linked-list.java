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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> map=new HashMap<>();
        ListNode curr=head;
        while(curr!=null){
            map.put(curr.val,map.getOrDefault(curr.val, 0)+1);
            curr=curr.next;
        }
        curr=head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(curr!=null){
            if(map.get(curr.val)>1){
                prev.next=curr.next;
            }else{
                prev=curr;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}