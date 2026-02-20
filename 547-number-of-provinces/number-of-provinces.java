class Solution {
    class UnionFind{
        int[] parents;
        int[] rank;
        public UnionFind(int n){
            this.parents = new int[n];
            this.rank = new int[n];
            for(int i=0;i<n;i++){
                parents[i] = i;
                rank[i]=1;
            }
        }
        public int find(int x){
            if(parents[x]==x){
                return x;
            }
            parents[x]=find(parents[x]);
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
                rank[vPar] += uPar;
            } else {
                parents[vPar] = uPar;
                rank[uPar] += vPar;
            }
            return true;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int province = n;
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    if(uf.union(i, j)){
                        province--;
                    }
                }
            }
        }
        return province;
    }
}