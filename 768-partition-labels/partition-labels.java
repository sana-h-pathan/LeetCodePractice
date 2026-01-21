class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int l = 0;
        int r = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            r = Math.max(r, map.get(ch));
            if(r==i){
                result.add(r-l+1);
                l = i+1;
            }
        }
        return result;
    }
}