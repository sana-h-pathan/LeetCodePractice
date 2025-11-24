class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        int countComponenent=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                 visited[i]=true;
                countComponenent++;
                bfs(adjacencyList, i,visited);
            }
        }
        return countComponenent;
    }

    private void bfs(List<List<Integer>> adjacencyList, int node, boolean[] visited){
        Queue<Integer> bfsQue=new LinkedList<>();
        bfsQue.add(node);
        while(!bfsQue.isEmpty()){
            int curr=bfsQue.poll();
            List<Integer> adjList=adjacencyList.get(curr);
            for(Integer adj: adjList){
                if(!visited[adj]){
                    visited[adj]=true;
                    bfsQue.add(adj);
                }
            }
        }
    }
}