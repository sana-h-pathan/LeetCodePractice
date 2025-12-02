class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        int idx=0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int completedCourses=0;
        Queue<Integer> bfsQue=new LinkedList<>();
        for(int[] pre: prerequisites){
            int ind = pre[1];
            int dep = pre[0];
            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(dep);
            indegree[dep]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                bfsQue.add(i);
                completedCourses++;
                result[idx++]=i;
            }
        }
        while(!bfsQue.isEmpty()){
            int curr = bfsQue.poll();
            if(map.containsKey(curr)){
                for(int depCourse: map.get(curr)){
                    indegree[depCourse]--;
                    if(indegree[depCourse]==0){
                        completedCourses++;
                        result[idx++]=depCourse;
                        if(completedCourses==numCourses)
                            return result;
                        bfsQue.add(depCourse);
                    }
                }
            }
        }
        if(completedCourses==numCourses)
            return result;
        return new int[0];
    }
}