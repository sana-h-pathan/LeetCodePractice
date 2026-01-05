class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] p : points){
            int x = p[0];
            int y = p[1];
            if(!map.containsKey(x)){
                map.put(x, new HashSet<>());
            }
            map.get(x).add(y);
        }
        int minArea = Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1!=x2 && y1!=y2){
                    if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                        int currArea = Math.abs(x2-x1) * Math.abs(y2-y1);
                        minArea = Math.min(minArea, currArea);
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;

    }
}