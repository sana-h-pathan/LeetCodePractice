class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{0, -1});
        visited[0]=true;
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int ne: adjList.get(node)){
                if(ne==parent){
                    continue;
                }
                if(visited[ne])
                    return false;
                visited[ne] = true;
                bfsQue.add(new int[]{ne, node});
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}