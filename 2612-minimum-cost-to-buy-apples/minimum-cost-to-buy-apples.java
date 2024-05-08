class Solution {
    
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        long[] minCost = new long[n];
        
        for(int i=0;i<n;++i) {
            minCost[i] = appleCost[i];
        }

        boolean modified = true;
        
        // This can go upto a max of V-1 times hence the runtime in O(V.E)
        while(modified) {
            modified = false; 
            for(int[] road:roads) {
                int cityA = road[0]-1;
                int cityB = road[1]-1;
                int roadCost = (k+1)*road[2];

                long newCostForA = roadCost+minCost[cityB];
                if(minCost[cityA]>newCostForA) {
                    modified = true;
                    minCost[cityA] = newCostForA;
                }

                long newCostForB = roadCost+minCost[cityA];
                if(minCost[cityB]>newCostForB) {
                    modified = true;
                    minCost[cityB] = newCostForB;
                }
            }
        }

        return minCost;
    }
}