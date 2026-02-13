class TimeMap {

    HashMap<String, ArrayList<Pair<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> list = map.get(key);

        int low = 0;
        int high = list.size() - 1;
        String result = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid).getKey() <= timestamp) {
                result = list.get(mid).getValue();  // possible answer
                low = mid + 1;                     // try to find later timestamp
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
