class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int sIdx=0;
        int eIdx=0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            eIdx = Math.max(eIdx, map.get(ch));
            if(eIdx==i){
                result.add(eIdx-sIdx+1);
                sIdx = i+1;
            }
        }
        return result;
    }
}