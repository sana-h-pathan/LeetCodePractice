class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int s = intervals[0][0];
        int e = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(e>=curr[0]){
                e = Math.max(curr[1], e);
            } else {
                result.add(new int[]{s,e});
                s = curr[0];
                e = curr[1];
            }
        }
        result.add(new int[]{s,e});
        return result.toArray(new int[0][]);
    }
}