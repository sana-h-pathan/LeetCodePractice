class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.length()==0){
            return 0;
        }
        int n = s.length();
        if(n<=k){
            return n;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        int maxLength=0;
        while(r<n){
            char rChar = s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0)+1);
            if(map.size()>k){
                char lChar = s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)-1);
                map.remove(lChar,0);
                l++;
            }
            maxLength = Math.max(r-l+1, maxLength);
            r++;
        }
        return maxLength;
    }
}