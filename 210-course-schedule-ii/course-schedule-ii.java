class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> dependencyMap=new HashMap<>();
        int[] indegreeCount=new int[numCourses];
        int[] result=new int[numCourses];
        for(int[] prereq: prerequisites){
            int prerequisiteCourse=prereq[1];
            int course=prereq[0];
            indegreeCount[course]++;
            if (!dependencyMap.containsKey(prerequisiteCourse)) {
                dependencyMap.put(prerequisiteCourse, new ArrayList<>());
            }
            dependencyMap.get(prerequisiteCourse).add(course);
        }
        Queue<Integer> bfsQueue=new LinkedList<>();
        int idx=0;

        // Add courses with no dependencies to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount[i] == 0) {
                bfsQueue.add(i);
                result[idx++]=i;
            }
        }
        while(!bfsQueue.isEmpty()){
            int currentCourse = bfsQueue.poll();
            List<Integer> dependentCourses = dependencyMap.get(currentCourse);
            if (dependentCourses != null) {
                for (int dependentCourse : dependentCourses) {
                    indegreeCount[dependentCourse]--;
                    if (indegreeCount[dependentCourse] == 0) {
                        bfsQueue.add(dependentCourse);
                        result[idx++]=dependentCourse;
                    }
                }
            }
        }
        if(idx == numCourses)
            return result;
        return new int[0];
    }
}