class HitCounter {
    Queue<Integer> hitCounter;
    public HitCounter() {
        this.hitCounter = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        hitCounter.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!hitCounter.isEmpty() && timestamp-hitCounter.peek()>=300){
            hitCounter.poll();
        }
        return hitCounter.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */