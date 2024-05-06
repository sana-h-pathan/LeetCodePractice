class Solution {
    HashMap<Integer, List<Integer>> map;
    List<List<Integer>> result;
    int[] discovery;
    int[] lowest;
    int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.map=new HashMap<>();
        this.discovery=new int[n];
        this.lowest=new int[n];
        Arrays.fill(discovery, -1);
        this.result=new ArrayList<>();
        buildGraph(connections,n);
        dfs(0,0);
        return result;
    }

    private void dfs(int v, int u){
        if(discovery[v]!=-1)
            return;
        discovery[v]=time;
        lowest[v]=time;
        time++;
        for(int ne: map.get(v)){
            if(ne==u)
                continue;
            dfs(ne, v);
            if(lowest[ne]> discovery[v])
                result.add(Arrays.asList(ne, v));
            lowest[v]=Math.min(lowest[v], lowest[ne]);
            
        }
    }

    private void buildGraph(List<List<Integer>> connections, int n){
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(List<Integer> edge: connections){
            int e1=edge.get(0);
            int e2=edge.get(1);
            map.get(e1).add(e2);
            map.get(e2).add(e1);
        }
    }

}