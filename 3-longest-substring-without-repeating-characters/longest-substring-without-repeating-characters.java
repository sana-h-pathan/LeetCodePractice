class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength=0;
        int l=0;
        int r=0;
        while(r<s.length()){
            char rChar = s.charAt(r);
            if(map.containsKey(rChar)){
                l = Math.max(l, map.get(rChar)+1);
            }
            map.put(rChar, r);
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}