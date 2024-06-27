class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] edge: edges){
            int e0=edge[0];
            int e1=edge[1];
            map.put(e0, map.getOrDefault(e0, 0)+1);
            if(map.get(e0)==n)
                return e0;
            map.put(e1, map.getOrDefault(e1, 0)+1);
            if(map.get(e1)==n)
                return e1;
        }
        return -1;
    }
}