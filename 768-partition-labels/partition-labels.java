class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        List<Integer> result = new ArrayList<>();
        int startIdx = 0;
        int endIdx = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            endIdx = Math.max(map.get(ch), endIdx);
            if(i==endIdx){
                result.add(endIdx-startIdx+1);
                startIdx = i+1;
            }
        }
        return result;
    }
}