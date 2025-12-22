class RandomizedSet {
    HashSet<Integer> set;
    Random random;
    List<Integer> numList;
    public RandomizedSet() {
        this.set = new HashSet<>();
        this.numList = new ArrayList<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        else{
            set.add(val);
            numList.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)){
            return false;
        }
        set.remove(val);
        numList.remove(Integer.valueOf(val));
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