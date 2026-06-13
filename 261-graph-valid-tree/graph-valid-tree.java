class Solution {
    class UnionFind{
        int[] ranks;
        int[] parents;
        public UnionFind(int n){
            this.parents = new int[n];
            this.ranks = new int[n];
            for(int i=0;i<n;i++){
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        public int find(int x){
            if(parents[x]==x){
                return x;
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
            if(ranks[uPar]<ranks[vPar]){
                parents[uPar] = vPar;
                ranks[vPar]+=ranks[uPar];
            } else {
                parents[vPar] = uPar;
                ranks[uPar]+=ranks[vPar];
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){ 
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
    }
}