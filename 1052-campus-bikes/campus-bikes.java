class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if(workers==null || bikes == null || workers.length == 0 || bikes.length==0){
            return new int[]{};
        }
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int m = bikes.length;
        int n = workers.length; //n<=m
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                int dist = calculateDistance(bikes[i],workers[j]);
                min = Math.min(min, dist);
                max = Math.max(max, dist);
                if(!map.containsKey(dist)){
                    map.put(dist, new ArrayList<>());
                }
                map.get(dist).add(new int[]{i,j});
            }
        }
        boolean[] availableWorker = new boolean[n];
        boolean[] availableBikes = new boolean[m];
        int count =0;
        int[] result = new int[n];
        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                for(int[] pair: map.get(i)){
                    int bike = pair[0];
                    int worker = pair[1];
                    if(!availableWorker[worker] && !availableBikes[bike]){
                        availableWorker[worker] = true;
                        availableBikes[bike] = true;
                        count++;
                        result[worker] = bike;
                        if(count==availableWorker.length){
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    private int calculateDistance(int[] bike, int[] worker){
        return Math.abs(bike[0]-worker[0])+ Math.abs(bike[1]-worker[1]);
    }
}