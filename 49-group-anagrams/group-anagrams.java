class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String newString = new String(strChar);
            if(!map.containsKey(newString)){
                map.put(newString, new ArrayList<>());
            }
            map.get(newString).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for(String str: map.keySet()){
            result.add(map.get(str));
        }
        return result;
    }
}