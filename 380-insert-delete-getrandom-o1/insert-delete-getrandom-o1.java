class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> numList;
    Random random;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.numList = new ArrayList<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, numList.size());
        numList.add(map.get(val), val);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int idx = map.get(val);
            int lastVal = numList.get(numList.size()-1);
            numList.set(idx, lastVal);
            map.put(lastVal, idx);
            numList.remove(numList.size()-1);
            map.remove(val);
            return true;
        }
        return false;
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