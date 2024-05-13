class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        HashMap<Integer,List<Integer>> courseMap=new HashMap();
        for(int[] pre: prerequisites){
            int dependent=pre[0];
            int independent=pre[1];
            if(!courseMap.containsKey(independent))
                courseMap.put(independent, new ArrayList<>());
            courseMap.get(independent).add(dependent);
            indegree[dependent]++;
        }
        int completedCourse=0;
        Queue<Integer> bfsQue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                bfsQue.add(i);
                completedCourse++;
            }
        }
        
        while(!bfsQue.isEmpty()){
            int course=bfsQue.poll();
            if(courseMap.containsKey(course)){
                List<Integer> dependentCourse=courseMap.get(course);
                for(int dc: dependentCourse){
                    indegree[dc]--;
                    if(indegree[dc]==0){
                        bfsQue.add(dc);
                        completedCourse++;
                    }
                }
            }
        }
        return completedCourse==numCourses;
    }
}