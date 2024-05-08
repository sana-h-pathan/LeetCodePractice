class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        int[] parent=new int[n];
        int[] rank=new int[n];
        Arrays.fill(rank, 1);
        for(int i=0;i<n;i++)
            parent[i]=i;
        
        for(int[] e: edges){
            if(!union(e[0],e[1],rank,parent))
                return new int[]{e[0],e[1]};
        }
        return null;
    }

    private int findParent(int n, int[] parent){
        int p=parent[n];
        while(parent[p]!=p){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    private boolean union(int e1, int e2, int[] rank, int[] parent){
        int px=findParent(e1, parent);
        int py=findParent(e2, parent);
        if(px==py)
            return false;
        if(rank[px]>rank[py]){
            rank[px]+=rank[py];
            parent[py]=parent[px];

        }
        else{
            rank[py]+=rank[px];
            parent[px]=parent[py];
        }
        return true;
    }
}