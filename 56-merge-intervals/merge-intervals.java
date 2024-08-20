class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result=new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int[] curr=intervals[i];
            if(end>=curr[0]){
                end=Math.max(end, curr[1]);
            }else{
                result.add(new int[]{start,end});
                start=curr[0];
                end=curr[1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[0][]);
    }
}