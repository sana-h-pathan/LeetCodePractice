class RandomizedSet {
    HashMap<Integer, Integer> map;
    Random random;
    List<Integer> numList;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.numList = new ArrayList<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        else{
            map.put(val, numList.size());
            numList.add(numList.size(),val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int lastVal = numList.get(numList.size()-1);
        int valIdx = map.get(val);
        numList.set(valIdx, lastVal);
        map.put(lastVal, valIdx);
        numList.remove(numList.size()-1);
        map.remove(val);
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