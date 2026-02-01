class AuthenticationManager {

    private final int ttl;
    private final Map<String, Integer> expiryByToken;
    private final PriorityQueue<Node> minHeap; // (expiry, token)

    private static class Node {
        int expiry;
        String token;
        Node(int expiry, String token) {
            this.expiry = expiry;
            this.token = token;
        }
    }

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        this.expiryByToken = new HashMap<>();
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.expiry));
    }

    public void generate(String tokenId, int currentTime) {
        int expiry = currentTime + ttl;
        expiryByToken.put(tokenId, expiry);
        minHeap.offer(new Node(expiry, tokenId));
    }

    public void renew(String tokenId, int currentTime) {
        // Remove expired first so we don't renew something that should be dead
        cleanup(currentTime);

        Integer expiry = expiryByToken.get(tokenId);
        if (expiry == null) return;              // token doesn't exist
        if (expiry <= currentTime) return;       // expired (defensive; cleanup should have removed)

        int newExpiry = currentTime + ttl;
        expiryByToken.put(tokenId, newExpiry);
        minHeap.offer(new Node(newExpiry, tokenId));
    }

    public int countUnexpiredTokens(int currentTime) {
        cleanup(currentTime);
        return expiryByToken.size();
    }

    private void cleanup(int currentTime) {
        // Pop heap entries that are expired OR stale (heap has older expiry than map)
        while (!minHeap.isEmpty()) {
            Node top = minHeap.peek();

            if (top.expiry > currentTime) {
                // earliest expiry is still valid => stop
                break;
            }

            minHeap.poll();
            Integer curExpiry = expiryByToken.get(top.token);

            // Remove from map only if this heap entry matches the token's current expiry
            // (otherwise it's a stale heap record from an old generate/renew)
            if (curExpiry != null && curExpiry == top.expiry) {
                expiryByToken.remove(top.token);
            }
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */