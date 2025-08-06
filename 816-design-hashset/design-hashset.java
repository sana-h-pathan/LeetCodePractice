class MyHashSet {
    private int firstLevel;
    private int secondLevel;
    private boolean[][] data;

    public MyHashSet() {
        this.firstLevel=1000;
        this.secondLevel=1000;
        this.data=new boolean[firstLevel][];
    }

    private int firstHashing(int number){
        return number%firstLevel;
    }

    private int secondHashing(int number){
        return number/secondLevel;
    }
    
    public void add(int key) {
        int firstHashingValue = firstHashing(key);
        int secondHashingValue = secondHashing(key);
        if(data[firstHashingValue]==null){
            if(firstHashingValue==0){
                data[firstHashingValue]=new boolean[secondLevel+1];
            }else{
                data[firstHashingValue]=new boolean[secondLevel];
            }
        }
        data[firstHashingValue][secondHashingValue]=true;
    }
    
    public void remove(int key) {
        int firstHashingValue = firstHashing(key);
        int secondHashingValue = secondHashing(key);
        if(data[firstHashingValue]==null)
            return;
        data[firstHashingValue][secondHashingValue]=false;
    }
    
    public boolean contains(int key) {
        int firstHashingValue = firstHashing(key);
        int secondHashingValue = secondHashing(key);
        if(data[firstHashingValue]==null)
            return false;
        return data[firstHashingValue][secondHashingValue];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */