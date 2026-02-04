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
            if(parents[x]==x){
                return x;
            }
            parents[x] = find(parents[x]);
            return parents[x];
        }

        private boolean union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu==pv){
                return false;
            }
            if(rank[pu]<rank[pv]){
                parents[pu]=pv;
                rank[pv]+= rank[pu];
            } else {
                parents[pv]=pu;
                rank[pu]+=rank[pv];
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