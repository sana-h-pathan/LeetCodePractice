class RandomizedSet {
    HashMap<Integer, Integer> numMap;
    List<Integer> numList;
    Random random;

    public RandomizedSet() {
        this.numList = new ArrayList<>();
        this.numMap = new HashMap<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if(numMap.containsKey(val)){
            return false;
        }
        numMap.put(val, numList.size());
        numList.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!numMap.containsKey(val)){
            return false;
        }
        //2:0,3:2,4:1
        //2,4,3
        int numIdx = numMap.get(val);
        int lastVal = numList.getLast();

        numMap.put(lastVal, numIdx);
        numList.set(numIdx, lastVal);

        numMap.remove(val);
        numList.remove(numList.size()-1);
        return true;
    }
    
    public int getRandom() {
        return numList.get(random.nextInt(numList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */