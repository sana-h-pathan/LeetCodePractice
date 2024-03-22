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
    public boolean isPalindrome(ListNode head) {
        List<Integer> linkedListList=new ArrayList<>();
        while(head!=null){
            linkedListList.add(head.val);
            head=head.next;
        }
        int index=0;
        int last=linkedListList.size()-1;
        while(last>index){
            if(linkedListList.get(index)!=linkedListList.get(last))
                return false;
            index++;
            last--;
        }
        return true;
    }
}