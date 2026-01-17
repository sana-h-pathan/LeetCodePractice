class PhoneDirectory {
    HashSet<Integer> set;
    Queue<Integer> queue;
    public PhoneDirectory(int maxNumbers) {
        this.set = new HashSet<>();
        this.queue = new LinkedList<>();
        for(int i=0;i<maxNumbers;i++){
            set.add(i);
            queue.add(i);
        }
    }
    
    public int get() {
        if(queue.isEmpty()){
            return -1;
        }
        int num = queue.poll();
        set.remove(num);
        return num;
    }
    
    public boolean check(int number) {
        return set.contains(number);
    }
    
    public void release(int number) {
        if(!set.contains(number)){
            queue.add(number);
            set.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */