/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> empMap=new HashMap<>();
        for(Employee e: employees)
            empMap.put(e.id,e);

        Queue<Integer> bfsQueue=new LinkedList<>();
        bfsQueue.add(id);
        int imp=0;
        while(!bfsQueue.isEmpty()){
            int curr=bfsQueue.poll();
            Employee e=empMap.get(curr);
            imp+=e.importance;
            List<Integer> sub=e.subordinates;
            for (int subordinate : e.subordinates) {
                bfsQueue.add(subordinate);
            }
        }
        return imp;
        
    }
}