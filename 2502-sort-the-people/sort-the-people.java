class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] result=new String[names.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<heights.length;i++){
            pq.add(new int[]{heights[i],i});
        }
        int idx=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            result[idx]=names[curr[1]];
            idx++;
        }
        return result;
    }
}