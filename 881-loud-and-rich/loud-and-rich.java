class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        int[] indegree=new int[n];
        int[] result=new int[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
            
        }
        for(int[] arr: richer){
            int poor=arr[1];
            int rich=arr[0];
            
            map.get(rich).add(poor);
            indegree[poor]++;
        }
        Queue<Integer> bfsQue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                bfsQue.add(i);
            result[i]=i;
        }
        while(!bfsQue.isEmpty()) {
            Integer curr = bfsQue.poll();
            for(Integer ne : map.get(curr)) {
                indegree[ne]--;
                if(indegree[ne] == 0) {
                    bfsQue.add(ne);
                }
                
                if(quiet[result[ne]] > quiet[result[curr]]) {
                    result[ne] = result[curr];
                }
            }
        }
        return result;
        
    }
}