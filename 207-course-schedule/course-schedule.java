class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre: prerequisites){
            int ind = pre[1];
            int dep = pre[0];
            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(dep);
            indegree[dep]++;
        }
        int completedCourses=0;
        Queue<Integer> bfsQue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                bfsQue.add(i);
                completedCourses++;
            }
        }
        if(completedCourses==n){
            return true;
        }
        while(!bfsQue.isEmpty()){
            int curr = bfsQue.poll();
            if(map.containsKey(curr)){
                for(int ne: map.get(curr)){
                    indegree[ne]--;
                    if(indegree[ne]==0){
                        completedCourses++;
                        if(completedCourses==n){
                            return true;
                        }
                        bfsQue.add(ne);
                    }
                }
            }
        }
        if(completedCourses==n){
            return true;
        } 
        return false;

    }
}