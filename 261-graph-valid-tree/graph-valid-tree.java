class Solution {
    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        } 
        private int find(int x){
            if(parent[x]==x){
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
        private boolean union(int u, int v){
            int uPar = find(u);
            int vPar = find(v);
            if(uPar == vPar){
                return false;
            }
            if(rank[uPar]<rank[vPar]){
                parent[uPar] = vPar;
                rank[vPar]+=rank[uPar];
            } else {
                parent[vPar] = uPar;
                rank[uPar]+=rank[vPar];
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        if(edges.length!=n-1){
            return false;
        }
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
    }
}