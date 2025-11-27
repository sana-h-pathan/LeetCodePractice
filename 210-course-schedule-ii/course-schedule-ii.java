class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        HashMap<Integer, List<Integer>> adjMap=new HashMap<>();
        int[] result=new int[numCourses];
        int completedCourse=0;
        for(int[] requisite : prerequisites){
            int ind=requisite[1];
            int dep=requisite[0];
            if(!adjMap.containsKey(ind)){
                adjMap.put(ind, new ArrayList<>());
            }
            adjMap.get(ind).add(dep);
            indegree[dep]++;
        }
        int idx=0;
        Queue<Integer> bfsQue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                bfsQue.add(i);
                result[idx++]=i;
                completedCourse++;
            }
        }
        while(!bfsQue.isEmpty()){
            int curr=bfsQue.poll();
            if(adjMap.containsKey(curr)){
                for(int course: adjMap.get(curr)){
                    indegree[course]--;
                    if(indegree[course]==0){
                        bfsQue.add(course);
                        result[idx++]=course;
                        completedCourse++;
                        if(completedCourse==numCourses)
                            return result;
                    }
                }
            }
        }
        if(completedCourse==numCourses)
            return result;
        return new int[0];
    }
}