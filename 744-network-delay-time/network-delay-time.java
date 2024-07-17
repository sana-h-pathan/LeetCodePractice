class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Map to store the edges and their weights
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        // Populate the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int weight = time[2];
            // If source node doesn't exist in the map, create a new entry
            adjacencyList.computeIfAbsent(source, x -> new ArrayList<>()).add(new int[]{destination, weight});
        }

        // Priority queue to select the next node with the minimum weight
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Add the starting node to the minHeap with weight 0
        minHeap.offer(new int[]{0, k});
        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        // Variable to store the maximum time to reach all nodes
        int maxTime = 0;

        // Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int weightToNode = node[0];
            int currentNode = node[1];

            // If the node is already visited, skip
            if (visited.contains(currentNode))
                continue;

            // Mark the node as visited
            visited.add(currentNode);
            // Update maxTime to the weight to reach this node
            maxTime = weightToNode;

            // If all nodes are visited, return the maximum time
            if (visited.size() == n)
                return maxTime;

            // If the current node has neighbors, add them to the minHeap
            if (adjacencyList.containsKey(currentNode)) {
                for (int[] edge : adjacencyList.get(currentNode)) {
                    int neighborNode = edge[0];
                    int edgeWeight = edge[1];
                    // If the neighbor is not visited, add it to the minHeap
                    if (!visited.contains(neighborNode)) {
                        minHeap.offer(new int[]{weightToNode + edgeWeight, neighborNode});
                    }
                }
            }
        }
        // Not all nodes are visited, return -1
        return -1;
    }
}
