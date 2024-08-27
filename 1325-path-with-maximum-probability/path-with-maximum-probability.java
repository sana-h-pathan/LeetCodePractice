class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            map.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            map.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        double[] result = new double[n];
        result[start] = 1d;
        Queue<Integer> bfsQue = new LinkedList<>(Arrays.asList(start));
        while (!bfsQue.isEmpty()) {
            int curr = bfsQue.poll();
            for (int[] ne : map.getOrDefault(curr, Collections.emptyList())) {
                int neighbor = ne[0];
                int index = ne[1];
                if (result[curr] * succProb[index] > result[neighbor]) {
                    result[neighbor] = result[curr] * succProb[index];
                    bfsQue.offer(neighbor);
                }
            }
        }
        return result[end];
    }
}