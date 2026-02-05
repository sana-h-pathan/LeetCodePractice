class Solution {
    public int characterReplacement(String s, int k) {
        if(s==null || s.length()==0 || k>s.length()){
            return s.length();
        }
        int maxFreq=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength=0;
        int l=0;
        int r=0;
        while(r<s.length()){
            char rChar = s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(rChar));
            if(r-l+1-maxFreq>k){
                char lChar = s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)-1);
                for(char ch: map.keySet()){
                    maxFreq = Math.max(maxFreq, map.get(ch));
                }
                l++;
            }
            maxLength=Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}