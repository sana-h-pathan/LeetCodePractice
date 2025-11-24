class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        int completedCourse=0;
        for(int[] pre: prerequisites){
            int ind=pre[1];
            int dep=pre[0];
            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            indegree[dep]++;
            map.get(ind).add(dep);
        }
        Queue<Integer> bfsQue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                bfsQue.add(i);
                completedCourse++;
            }
        }
        while(!bfsQue.isEmpty()){
            int curr=bfsQue.poll();
            if(map.containsKey(curr)){
                List<Integer> depCourse=map.get(curr);
                for(int course: depCourse){
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