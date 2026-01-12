class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if(workers==null || workers.length==0 ||bikes==null || bikes.length==0 )
            return new int[]{};
        int b=bikes.length;
        int w=workers.length;
        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        HashMap<Integer, List<int[]>> map=new HashMap<>();
        for(int i=0;i<b;i++){
            for(int j=0;j<w;j++){
                int dist=Math.abs(workers[j][0]-bikes[i][0])+Math.abs(workers[j][1]-bikes[i][1]);
                min=Math.min(min, dist);
                max=Math.max(max, dist);
                if(!map.containsKey(dist))
                    map.put(dist, new ArrayList<>());
                map.get(dist).add(new int[]{i,j});
            }
        }

        boolean[] availableWorker=new boolean[w];
        boolean[] availableBikes=new boolean[b];
        int count=0;
        int[] result=new int[w];
        for(int i=min;i<=max;i++){
            List<int[]>  temp=map.get(i);
            if(temp!=null){
                for(int[] tmp: temp){
                    int tmpB=tmp[0];
                    int tmpW=tmp[1];
                    if(!availableBikes[tmpB] && !availableWorker[tmpW]){
                        availableBikes[tmpB]=true;
                        availableWorker[tmpW]=true;
                        count++;
                        result[tmpW]=tmpB;
                        if(count==workers.length)
                            break;
                    }
                }
            }
        }
        return result;
    }
}