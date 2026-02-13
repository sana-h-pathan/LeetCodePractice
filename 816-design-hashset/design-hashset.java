class MyHashSet {
    int firstLevel;
    int secondLevel;
    boolean[][] dataSet;
    public MyHashSet() {
        this.firstLevel = 1000;
        this.secondLevel = 1000;
        this.dataSet = new boolean[firstLevel][];
    }
    private int firstHashing(int key){
        return key%firstLevel;
    }

    private int secondHashing(int key){
        return key/firstLevel;
    }
    
    public void add(int key) {
        int fKey = firstHashing(key);
        int sKey = secondHashing(key);
        if(dataSet[fKey]==null){
            if(fKey==0){
                dataSet[fKey] = new boolean[secondLevel+1];
            } else {
                dataSet[fKey] = new boolean[secondLevel];
            }
        }
        dataSet[fKey][sKey]=true;
    }
    
    public void remove(int key) {
        int fKey = firstHashing(key);
        int sKey = secondHashing(key);
        if(dataSet[fKey]==null){
            return;
        }
        dataSet[fKey][sKey]=false;
        return;
    }
    
    public boolean contains(int key) {
        int fKey = firstHashing(key);
        int sKey = secondHashing(key);
        if(dataSet[fKey]==null){
            return false;
        }
        return dataSet[fKey][sKey];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */