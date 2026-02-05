class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxLength=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                l = Math.max(map.get(ch)+1, l);
            }
            map.put(ch, r);
            maxLength=Math.max(r-l+1, maxLength);
            r++;
        }
        return maxLength;
    }
}