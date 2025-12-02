class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int startPoint=intervals[0][0];
        int endPoint=intervals[0][1];
        List<int[]> result=new ArrayList<>();
        for(int[] interval: intervals){
            if(interval[0]<=endPoint){
                endPoint=Math.max(endPoint, interval[1]);
                //result.add(new int[]{startPoint, endPoint});
            } else{
                result.add(new int[]{startPoint, endPoint});
                startPoint=interval[0];
                endPoint=interval[1];
            }
        }
        result.add(new int[]{startPoint, endPoint});
        return result.toArray(new int[0][]); 
    }
}