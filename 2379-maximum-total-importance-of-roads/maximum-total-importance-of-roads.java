class Solution {
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int[] road: roads){
            map.put(road[0], map.getOrDefault(road[0], 0)+1);
            map.put(road[1], map.getOrDefault(road[1], 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet()) {
            pq.add(key);
        }
        
        // Assign importance values to cities, starting from the highest value
        long answer = 0;
        int count = n;
        while (!pq.isEmpty()) {
            answer += (long) map.get(pq.poll()) * count;
            count--;
        }
        return answer;
    }
}