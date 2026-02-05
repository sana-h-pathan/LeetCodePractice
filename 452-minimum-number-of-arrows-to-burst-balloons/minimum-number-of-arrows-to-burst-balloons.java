class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0){
            return 0;
        }
        int count=1;
        Arrays.sort(points, (a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int prev = points[0][1];
        for(int i=1;i<points.length;i++){
            int[] curr = points[i];
            if(prev<curr[0]){
                count++;
                prev = curr[1];
            }
        }
        return count;
    }
}