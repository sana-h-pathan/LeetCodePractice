package practice.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestElementInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int initCapacity = 1000;
        PriorityQueue<Integer> pq = new PriorityQueue<>(initCapacity, Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
                if(pq.size() > k){
                     pq.poll();
                }

            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        KSmallestElementInMatrix kSmallestElementInMatrix=new KSmallestElementInMatrix();
        System.out.println(kSmallestElementInMatrix.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }
}
