class MyHashSet {
    private int firstLevel;
    private int secondLevel;
    private boolean[][] hashData;
    public MyHashSet() {
        this.firstLevel = 1000;
        this.secondLevel = 1000;
        this.hashData = new boolean[1000][];
    }

    private int firstHashing(int number){
        return number%firstLevel;
    }
    private int secondHashing(int number){
        return number/secondLevel;
    }
    
    public void add(int key) {
        int fKey = firstHashing(key);
        int sKey = secondHashing(key);
        if(hashData[fKey]==null){
            if(fKey==0){
                hashData[fKey] = new boolean[secondLevel+1];
            } else {
                hashData[fKey] = new boolean[secondLevel];
            }
        }
        hashData[fKey][sKey]=true;
    }
    
    public void remove(int key) {
        int fKey = firstHashing(key);
        int sKey = secondHashing(key);
        if(hashData[fKey]!=null){
            hashData[fKey][sKey]=false;
        }
    }
    
    public boolean contains(int key) {
        int fKey = firstHashing(key);
        int sKey = secondHashing(key);
        if(hashData[fKey]==null){
           return false;
        } else {
            return hashData[fKey][sKey];
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */