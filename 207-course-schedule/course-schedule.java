class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> bfsQue = new LinkedList<>();
        for(int[] pre: prerequisites){
            int ind = pre[1];
            int dep = pre[0];
            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(dep);
            indegree[dep]++;
        }
        int completedCourse = 0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                completedCourse++;
                bfsQue.add(i);
            }
        }
        if(numCourses==completedCourse)
            return true;
        while (!bfsQue.isEmpty()) {
            int curr = bfsQue.poll();
            if(map.containsKey(curr)){
                for(int dep: map.get(curr)){
                    indegree[dep]--;
                    if(indegree[dep]==0){
                        completedCourse++;
                        bfsQue.add(dep);
                    }
                }
            }
        }
        return completedCourse==numCourses;
    }
}