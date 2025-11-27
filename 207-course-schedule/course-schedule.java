class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegree=new int[numCourses];
       HashMap<Integer, List<Integer>> adjMap=new HashMap<>();
       for(int[] requisite: prerequisites){
            int dep=requisite[0];
            int ind=requisite[1];
            if(!adjMap.containsKey(ind)){
                adjMap.put(ind, new ArrayList<>());
            }
            adjMap.get(ind).add(dep);
            indegree[dep]++;
        }
        int completedCourse=0;
        Queue<Integer> bfsQue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                completedCourse++;
                bfsQue.add(i);
            }
        }
        while(!bfsQue.isEmpty()){
            int curr=bfsQue.poll();
            if(adjMap.containsKey(curr)){
                for(int course: adjMap.get(curr)){
                    indegree[course]--;
                    if(indegree[course]==0){
                        bfsQue.add(course);
                        completedCourse++;
                        if(completedCourse==numCourses)
                            return true;
                    }
                }
            }
        }
        return completedCourse==numCourses;
    }
}