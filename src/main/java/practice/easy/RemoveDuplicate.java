package practice.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicate {
    public String removeDuplicates(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) {
                dq.pollLast();
            }else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { sb.append(c); }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate=new RemoveDuplicate();
        System.out.println(removeDuplicate.removeDuplicates("azxxzy"));
    }
}
