class Solution {
    class UnionFind{
        int[] parents; 
        int[] rank;
        public UnionFind(int n){
            this.parents = new int[n];
            this.rank = new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                rank[i]=1;
            }
        }
        private int find(int x){
            if(x==parents[x]){
                return x;
            }
            parents[x] = find(parents[x]);
            return parents[x];
        }
        private boolean union(int u, int v){
            int uPar = find(u);
            int vPar = find(v);
            if(uPar==vPar){
                return false;
            }
            if(rank[uPar]<rank[vPar]){
                parents[uPar] = vPar;
                rank[vPar] += rank[uPar];
            } else {
                parents[vPar] = uPar;
                rank[uPar] += rank[vPar];
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0]-1, edge[1]-1)){
                return edge;
            }
        }
        return new int[0];
    }
}