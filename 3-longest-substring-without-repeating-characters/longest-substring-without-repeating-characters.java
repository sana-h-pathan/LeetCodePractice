class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxLength=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            char rChar = s.charAt(r);
            if(map.containsKey(rChar)){
                if(map.get(rChar)>=l){
                    l = map.get(rChar)+1;
                }
            }
            map.put(rChar, r);
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}