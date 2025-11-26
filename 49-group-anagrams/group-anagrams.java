class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(String str: strs){
            char[] sChar=str.toCharArray();
            Arrays.sort(sChar);
            String sortString=new String(sChar);
            if(!map.containsKey(sortString)){
                map.put(sortString, new ArrayList<>());
            }
            map.get(sortString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}