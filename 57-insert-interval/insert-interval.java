class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        for(int[] interval: intervals){
            // If the end of the new is before the start of the current interval
            if(newInterval[1]<interval[0]){
                result.add(newInterval);
                newInterval=interval;
            } 
            // If the start of the new in after end of current interval
            else if(newInterval[0]>interval[1]){
                result.add(interval);
            } else {
                newInterval[0]=Math.min(interval[0], newInterval[0]);
                newInterval[1]=Math.max(interval[1], newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[0][]); 
    }
}