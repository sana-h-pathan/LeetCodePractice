class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int b = bikes.length;
        int w = workers.length;
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<b;i++){
            for(int j=0;j<w;j++){
                int dist = calculateDistance(bikes[i], workers[j]);
                maxDist = Math.max(dist, maxDist);
                minDist = Math.min(dist, minDist);
                if(!map.containsKey(dist)){
                    map.put(dist, new ArrayList<>());
                }
                map.get(dist).add(new int[]{i,j});
            }
        }
        boolean[] availableB = new boolean[b];
        boolean[] availableW = new boolean[w];
        int[] result = new int[w];
        int count =0;
        for(int i=minDist;i<=maxDist;i++){
            if(map.containsKey(i)){
                for(int[] pair : map.get(i)){
                    int bike = pair[0];
                    int worker = pair[1];
                    if(!availableB[bike] && !availableW[worker]){
                        result[worker] = bike;
                        availableB[bike]= true;
                        availableW[worker]=true;
                        count++;
                        if(count==w){
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }
    private int calculateDistance(int[] bikes, int[] workers){
        return Math.abs(bikes[0]-workers[0])+Math.abs(bikes[1]-workers[1]);
    }
}