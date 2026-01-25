class AuthenticationManager {

    HashMap<String, Integer> map;
    int time;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        time = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + time);
    }

    public void renew(String tokenId, int currentTime) {
        int expires = map.getOrDefault(tokenId, 0);
        if (expires > currentTime) 
            map.put(tokenId, currentTime + time);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : map.keySet()){
            if (map.get(key) > currentTime){
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */