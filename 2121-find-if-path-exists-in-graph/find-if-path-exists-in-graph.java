class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[]edge : edges){
            int x=edge[0];
            int y=edge[1];
            if(!map.containsKey(x))
                map.put(x, new ArrayList<>());
            if(!map.containsKey(y))
                map.put(y, new ArrayList<>());
            map.get(x).add(y);
            map.get(y).add(x);
        }
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> bfsQue=new LinkedList<>();
        bfsQue.add(source);
        while(!bfsQue.isEmpty()){
            int curr = bfsQue.poll();
            if (curr == destination) 
                return true; 
            if(map.containsKey(curr)){
                for (int child : map.get(curr)) {
                    if (!seen[child]) {
                        seen[child] = true;
                        bfsQue.offer(child);
                    }
                }
            }
        }
        return false;
    }
}