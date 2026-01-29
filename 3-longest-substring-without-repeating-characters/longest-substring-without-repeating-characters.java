class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength=0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                l = Math.max(l, map.get(ch)+1);
            }
            map.put(ch, r);
            maxLength = Math.max(r-l+1, maxLength);
            r++;
        }
        return maxLength;
    }
}