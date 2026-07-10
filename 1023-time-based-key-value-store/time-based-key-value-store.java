class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair<Integer, String>> list = map.get(key);
        int low = 0;
        int high = list.size()-1;
        String result = "";
        while(low<=high){
            int mid = low+(high-low)/2;
            if(list.get(mid).getKey()<=timestamp){
                result = list.get(mid).getValue();
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }
    public void delete(String key, int timestamp) {
    if (!map.containsKey(key)) {
        return;
    }

    List<Pair<Integer, String>> list = map.get(key);

    int low = 0;
    int high = list.size() - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (list.get(mid).getKey() == timestamp) {
            list.remove(mid);

            if (list.size() == 0) {
                map.remove(key);
            }

            return;
        } else if (list.get(mid).getKey() < timestamp) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */