class MyHashMap {
    int firstLevel;
    int secondLevel;
    int[][] dataMap;

    public MyHashMap() {
        this.firstLevel = 1000;
        this.secondLevel = 1000;
        this.dataMap = new int[firstLevel][];
    }

    private int firstHashing(int key){
        return key%firstLevel;
    }

    private int seconHashing(int key){
        return key/secondLevel;
    }
    
    public void put(int key, int value) {
        int fKey = firstHashing(key);
        int sKey = seconHashing(key);
        if(dataMap[fKey]==null){
            if(fKey==0){
                dataMap[fKey] = new int[secondLevel+1];
            } else {
                dataMap[fKey] = new int[secondLevel];
            }
            Arrays.fill(dataMap[fKey], -1);
        }
        dataMap[fKey][sKey]=value;
    }
    
    public int get(int key) {
        int fKey = firstHashing(key);
        int sKey = seconHashing(key);
        if(dataMap[fKey]==null){
            return -1;
        }
        return dataMap[fKey][sKey];
    }
    
    public void remove(int key) {
        int fKey = firstHashing(key);
        int sKey = seconHashing(key);
        if(dataMap[fKey]==null){
            return;
        }
        dataMap[fKey][sKey]=-1;
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */