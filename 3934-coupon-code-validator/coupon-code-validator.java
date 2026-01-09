class Solution {
    public List<String> validateCoupons(String[] codes, String[] businessLine, boolean[] isActive) {
        List<String> result = new ArrayList<>();
        String[] priority = {"electronics", "grocery", "pharmacy", "restaurant"};
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < codes.length; i++) {
            String code = codes[i];
            String business = businessLine[i];
            boolean status = isActive[i];

            if (status && code != null && code.matches("[a-zA-Z0-9_]+")) {
                if(!map.containsKey(business)){
                    map.put(business, new ArrayList<>());
                }
                map.get(business).add(code);
            }
        }

        for (String business : priority) {
            List<String> list = map.get(business);
            if (list == null) continue;

            Collections.sort(list);
            result.addAll(list);
        }
        return result;
    }
}
