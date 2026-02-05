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

        private int find(int u){
            if(parents[u]==u){
                return u;
            }
            parents[u]=find(parents[u]);
            return parents[u];
        }

        private boolean union(int u, int v){
            int uPar = find(u);
            int vPar = find(v);
            if(uPar==vPar){
                return false;
            }
            if(rank[uPar]<rank[vPar]){
                parents[uPar] = vPar;
                rank[vPar]+=rank[uPar];
            } else {
                parents[vPar] = uPar;
                rank[uPar] = vPar;
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        if(edges.length!=n-1){
            return false;
        }
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
    }
}