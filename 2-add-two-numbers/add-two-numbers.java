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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode=new ListNode(0);
        ListNode l3=dummyNode;
        int carry=0;
        while(l1!=null || l2!=null){
            int num1=l1!=null?l1.val:0;
            int num2=l2!=null?l2.val:0;
            
            int sum=num1+num2+carry;
            carry=sum/10;
            l3.next=new ListNode(sum%10);
            
            
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            l3=l3.next;

            if(carry>0)
                l3.next=new ListNode(carry);
        }
        return dummyNode.next;
    }
}