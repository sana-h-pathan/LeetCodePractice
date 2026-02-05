class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        Integer prev = null;
        int count=0;
        for(int[] interval : intervals){
            if(prev!=null && interval[0]<prev){
                count++;
            } else {
                prev = interval[1];
            }
        }
        return count;
    }
}