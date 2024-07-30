class Solution {
    class Tupple{
        int stop;
        int src;
        int cost;
        Tupple(int stop, int src, int cost){
            this.stop=stop;
            this.cost=cost;
            this.src=src;
        }
    }
    class Pair{
        int dest, cost;
        Pair(int dest, int cost){
            this.dest=dest;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            adjList.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }
        int[] distance=new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;
        Queue<Tupple> bfsQue=new LinkedList<>();
        bfsQue.add(new Tupple(0,src,0));
        while(!bfsQue.isEmpty()){
            Tupple curr=bfsQue.poll();
            int cStop=curr.stop;
            int cCost=curr.cost;
            int cSrc=curr.src;
            if(cStop > k) 
                continue; 
            for(Pair p: adjList.get(cSrc)){
                if(distance[p.dest]>cCost+p.cost && cStop<=k){
                    distance[p.dest]=cCost+p.cost;
                     bfsQue.add(new Tupple(cStop+1,p.dest,cCost+p.cost));
                }
            }
        }
        if(distance[dst]==Integer.MAX_VALUE)
            return -1;
        return distance[dst];
    }
}