class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int prev = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(curr[0]<prev){
                count++;
            } else {
                prev = curr[1];
            }
        }
        return count;
    }
}