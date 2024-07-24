class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        HashMap<Integer, List<int[]>> graph = new HashMap();
        for(int i=0;i<n;i++){
            graph.put(i, new LinkedList<int[]>());
        }
        for(int[] e: highways) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0, discounts});
        int[][] dp = new int[n][discounts+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        dp[0][discounts] = 0;
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            if(cur[0] == n-1) {
                ans = Math.min(ans, cur[1]);
            }
            if(ans < cur[1]) {
                continue;
            }
            for(int[] x: graph.get(cur[0])){
                if(dp[x[0]][cur[2]] == -1 || dp[x[0]][cur[2]] > x[1] + cur[1]) {
                    dp[x[0]][cur[2]] = x[1] + cur[1];
                    q.add(new int[] {x[0], cur[1] + x[1], cur[2]});
                }
                if(cur[2]>0){
                    if(dp[x[0]][cur[2]-1] == -1 || dp[x[0]][cur[2]-1] > x[1]/2 + cur[1]) {
                        q.add(new int[] {x[0], cur[1] + x[1]/2, cur[2]-1});
                        dp[x[0]][cur[2]-1] = x[1]/2 + cur[1];
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}