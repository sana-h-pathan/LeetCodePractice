class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num: nums)
            pq.add(num);
        int idx=0;
        while(!pq.isEmpty()){
            nums[idx++]=pq.poll();
        }
        return nums;
    }
}