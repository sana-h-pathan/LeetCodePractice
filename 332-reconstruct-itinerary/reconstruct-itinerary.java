class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (!map.containsKey(from))
                map.put(from, new PriorityQueue<>());

            map.get(from).add(to);
        }

        List<String> route = new ArrayList<>();   // changed: ArrayList
        Deque<String> dq = new ArrayDeque<>();
        dq.push("JFK");

        while (!dq.isEmpty()) {
            String dest = dq.peek();
            while (map.containsKey(dest) && !map.get(dest).isEmpty()) {
                dq.push(map.get(dest).poll());
                dest = dq.peek();   // changed: update dest
            }

            route.add(dq.pop());    // changed: normal add
        }

        Collections.reverse(route); // changed: reverse at end

        return route;
    }
}
