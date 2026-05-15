class Solution {
    class UnionFind{
        int[] parents;
        int[] rank;
        public UnionFind(int n){
            this.parents = new int[n];
            this.rank = new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            if(parents[x]==x){
                return parents[x];
            }
            parents[x] = find(parents[x]);
            return parents[x];
        }

        public boolean union(int u, int v){
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
                rank[uPar]+=rank[vPar];
            }
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        int component=0;
        for(int i=0;i<n;i++){
            if(uf.find(i)==i){
                component++;
            }
        }
        return component;
    }
}