class Solution {
    int[] parents;
   
    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        for(int i = 0;i<n;i++){
            parents[i] = i;
        }
        
        for(int[] e : edges){
            int a = find(e[0]);
            int b = find(e[1]);
            if(a !=b){
                parents[a] = b;
                n--;
            }
        }
        return n;
    }
    
    private int find(int id){
        if(id==parents[id]){
            return id;
        }
        parents[id]=find(parents[id]);
        return parents[id];
    }
}