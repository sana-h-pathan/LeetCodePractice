class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[] result = new int[k];
        List<Integer> temp = new ArrayList<>();
        for(int num: map.keySet()){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int idx=0;
        while(!pq.isEmpty()){
            result[idx++]=pq.poll();
        }
        return result;
    }
}