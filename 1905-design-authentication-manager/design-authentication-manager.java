class AuthenticationManager {

    private final int ttl;
    private final Map<String, Integer> expMap;  // token -> latest expiry
    private final PriorityQueue<Entry> pq;      // entries sorted by expiry

    private static class Entry {
        int exp;
        String token;
        Entry(int exp, String token) {
            this.exp = exp;
            this.token = token;
        }
    }

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
        expMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> a.exp - b.exp);
    }

    public void generate(String tokenId, int currentTime) {
        int exp = currentTime + ttl;
        expMap.put(tokenId, exp);
        pq.offer(new Entry(exp, tokenId)); // keep record for cleanup later
    }

    public void renew(String tokenId, int currentTime) {
        cleanup(currentTime);

        Integer oldExp = expMap.get(tokenId);
        if (oldExp == null) return;           // doesn't exist / already expired
        if (oldExp <= currentTime) return;    // expired (defensive)

        int newExp = currentTime + ttl;
        expMap.put(tokenId, newExp);
        pq.offer(new Entry(newExp, tokenId)); // old pq entry becomes stale
    }

    public int countUnexpiredTokens(int currentTime) {
        cleanup(currentTime);
        return expMap.size();
    }

    private void cleanup(int currentTime) {
        // Remove expired tokens from map.
        // pq can have stale records, so remove from map only if it matches latest expiry.
        while (!pq.isEmpty() && pq.peek().exp <= currentTime) {
            Entry e = pq.poll();

            Integer latestExp = expMap.get(e.token);
            // If map still has same expiry as this pq record => token truly expired now
            if (latestExp != null && latestExp == e.exp) {
                expMap.remove(e.token);
            }
            // else: stale record (token was renewed) OR token already removed -> ignore
        }
    }
}
