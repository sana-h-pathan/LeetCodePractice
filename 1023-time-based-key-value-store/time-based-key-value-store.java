class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair<Integer, String>> list = map.get(key);
        int high = list.size();
        int low = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(list.get(mid).getKey()<=timestamp){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        if(high==0){
            return "";
        }
        return list.get(high-1).getValue();
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */