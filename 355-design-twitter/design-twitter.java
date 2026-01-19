class Twitter {
    class Tweets{
        int tweetId;
        int tTime;
        public Tweets(int tweetId, int tTime){
            this.tweetId = tweetId;
            this.tTime = tTime;
        }
    }
    HashMap<Integer, Set<Integer>> followerMap;
    HashMap<Integer, List<Tweets>> tweetMap;
    int time;
    int k;

    public Twitter() {
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.time=0;
        this.k = 10;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
            follow(userId, userId);
        }
        tweetMap.get(userId).add(new Tweets(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweets> pq = new PriorityQueue<>((a,b)->a.tTime-b.tTime);
        if(followerMap.containsKey(userId)){
            for(int follower: followerMap.get(userId)){
                List<Tweets> tweets = tweetMap.get(follower);
                if (tweets != null) {
                    for (int i = tweets.size() - 1; i >= tweets.size() - k && i >= 0; i--) {
                        Tweets tweet = tweets.get(i);
                        pq.add(tweet);
                        if (pq.size() > k) {
                            pq.poll();
                        }
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().tweetId);
        }

        Collections.reverse(result);
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId)){
            followerMap.put(followerId, new HashSet<>());
        }
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId)){
            followerMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */