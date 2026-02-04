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
        public int find(int x){
            if(x==parent[x]){
                return x;
            }
            parent[x]=find(parent[x]);
            return parent[x];
        }
        public boolean union(int u, int v){
            int uParent = find(u);
            int vParent = find(v);
            if(uParent==vParent){
                return false;
            }
            if(uParent<vParent){
                parent[uParent]=vParent;
                rank[uParent]+= rank[vParent];
            } else {
                parent[vParent]=uParent;
                rank[vParent]+=rank[uParent];
            }
            return true;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int count = n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    if(uf.union(i, j)){
                        count--;
                    }
                }
            }
        }
        return count<1?1:count;
    }
}