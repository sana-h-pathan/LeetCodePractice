package practice.easy;

import LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicateInUnsortedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        curr = dummy;
        while (head != null) {
            if (map.get(head.val) == 1) {
                curr.next = head;
                curr = curr.next;
            }

            head = head.next;
        }

        curr.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(10);
        start.next = new ListNode(12);
        start.next.next = new ListNode(11);
        start.next.next.next = new ListNode(7);
        start.next.next.next.next = new ListNode(8);
        start.next.next.next.next.next = new ListNode(11);
        start.next.next.next.next.next.next = new ListNode(10);
        DeleteDuplicateInUnsortedList deleteDuplicateInUnsortedList=new DeleteDuplicateInUnsortedList();
        deleteDuplicateInUnsortedList.deleteDuplicatesUnsorted(start);
    }
}
