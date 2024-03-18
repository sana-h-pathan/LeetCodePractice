class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> dependencyMap=new HashMap<>();
        int[] indegreeCount=new int[numCourses];
        int[] result=new int[numCourses];
        Queue<Integer> bfsQueue=new LinkedList<>();
        int idx=0;
        
        // Populate indegree count and dependency map
        for(int[] prereq: prerequisites){
            int prerequisiteCourse=prereq[1];
            int course=prereq[0];
            indegreeCount[course]++;
            if (!dependencyMap.containsKey(prerequisiteCourse)) {
                dependencyMap.put(prerequisiteCourse, new ArrayList<>());
            }
            dependencyMap.get(prerequisiteCourse).add(course);
        }

        // Add courses with no prerequisites to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount[i] == 0) {
                bfsQueue.add(i);
            }
        }

        // Perform BFS traversal
        while (!bfsQueue.isEmpty()) {
            int currentCourse = bfsQueue.poll();
            // Add the current course to the result array
            result[idx++] = currentCourse;
            // Decrement the count of prerequisites for each dependent course
            List<Integer> dependentCourses = dependencyMap.getOrDefault(currentCourse, Collections.emptyList());
            for (int dependentCourse : dependentCourses) {
                indegreeCount[dependentCourse]--;
                // If the prerequisites for the dependent course become zero, add it to the queue
                if (indegreeCount[dependentCourse] == 0) {
                    bfsQueue.add(dependentCourse);
                }
            }
        }
        // Check if all courses are included in the result array
        if (idx == numCourses)
            return result;
        // If not all courses are included, return an empty array
        return new int[0];
    }
}