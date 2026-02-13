class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int s = intervals[0][0];
        int e = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals){
            if(interval[0]<=e){
                e = Math.max(e, interval[1]);
            } else {
                result.add(new int[]{s,e});
                s=interval[0];
                e=interval[1];
            }
        }
        result.add(new int[]{s,e});
        return result.toArray(new int[0][]);
    }
}