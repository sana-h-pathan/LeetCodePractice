package practice.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals,(a, b)-> a[0] - b[0]);
        LinkedList<int[]> res= new LinkedList<>();
        for(int[] interval: intervals){
            if(res.isEmpty() || interval[0] > res.getLast()[1]){
                res.add(interval);
            } else{
                res.getLast()[1] = Math.max(interval[1], res.getLast()[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals=new MergeIntervals();
        System.out.println(mergeIntervals.merge(new int[][]{{1,3},{4,7},{2,6},{8,10},{15,18}}));
    }
}
