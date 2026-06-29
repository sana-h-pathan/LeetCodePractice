class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
        for(int[] pre: prerequisites){
            int ind = pre[1];
            int dep = pre[0];
            if(!courseMap.containsKey(ind)){
                courseMap.put(ind, new ArrayList<>());
            }
            courseMap.get(ind).add(dep);
            indegree[dep]++;
        }
        int completedCourse = 0;
        Queue<Integer> bfsQue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                bfsQue.add(i);
                completedCourse++;
            }
        }
        if(completedCourse==n){
            return true;
        }
        while(!bfsQue.isEmpty()){
            int curr = bfsQue.poll();
            if(courseMap.containsKey(curr)){
                for(int ne: courseMap.get(curr)){
                    indegree[ne]--;
                    if(indegree[ne]==0){
                        bfsQue.add(ne);
                        completedCourse++;
                        if(completedCourse==n){
                            return true;
                        }
                    }
                }
            }
        }
        return completedCourse==n;
    }
}