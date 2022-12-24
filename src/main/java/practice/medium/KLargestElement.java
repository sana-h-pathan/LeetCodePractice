package practice.medium;

import java.util.*;

public class KLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KLargestElement kLargestElement=new KLargestElement();
        kLargestElement.findKthLargest(new int[]{2,5,3,1,7,9,4},3);
    }
}
