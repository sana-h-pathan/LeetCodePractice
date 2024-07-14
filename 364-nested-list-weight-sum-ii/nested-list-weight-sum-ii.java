/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> que=new LinkedList<NestedInteger>();
        List<Integer> eleDepth=new ArrayList<>();
        List<Integer> eleValue=new ArrayList<>();
        que.addAll(nestedList);
        int depth=1;
        int maxDepth=0;
        int sum=0;
        while(!que.isEmpty()){
            int size=que.size();
            maxDepth=Math.max(depth, maxDepth);
            for(int i=0;i<size;i++){
                NestedInteger curr=que.poll();
                if(curr.isInteger()){
                    eleDepth.add(depth);
                    eleValue.add(curr.getInteger());
                }else{
                    que.addAll(curr.getList());
                }
            }
            depth++;
        }
        for(int i=0;i<eleDepth.size();i++){
            sum+=(maxDepth-eleDepth.get(i)+1)*eleValue.get(i);
        }
        return sum;
    }
}