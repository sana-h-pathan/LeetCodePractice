class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }

        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Map.Entry<Integer, String> entry =
                map.get(key).floorEntry(timestamp);

        if (entry == null) {
            return "";
        }

        return entry.getValue();
    }
    public void delete(String key, int timestamp) {
        if(!map.containsKey(key)){
            return;
        }
        map.get(key).remove(timestamp);
        if(map.get(key).size()==0){
            map.remove(key);
        }
        return;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */