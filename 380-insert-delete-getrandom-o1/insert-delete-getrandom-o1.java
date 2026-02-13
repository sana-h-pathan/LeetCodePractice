class RandomizedSet {
    HashMap<Integer, Integer> numMap;
    List<Integer> numList;
    Random random;
    public RandomizedSet() {
        this.random = new Random();
        this.numList = new ArrayList<>();
        this.numMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(numMap.containsKey(val)){
            return false;
        }
        numMap.put(val, numList.size());
        numList.add(val);
        return true;
        
    }
    //1-0, 2-1, 3-2, 4-3, 5-4
    //1,2,3,4,5
    //remove 3
    public boolean remove(int val) {
        if(!numMap.containsKey(val)){
            return false;
        }
        int idx = numMap.get(val);
        int lastIdx = numList.size()-1;
        int swapVal = numList.get(lastIdx);
        
        numList.set(idx, swapVal);
        numMap.put(swapVal, idx);
        
        numList.remove(lastIdx);
        numMap.remove(val);
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