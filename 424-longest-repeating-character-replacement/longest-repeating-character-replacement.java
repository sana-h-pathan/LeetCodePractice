class Solution {
    public int characterReplacement(String s, int k) {
        int r=0;
        int l=0;
        int maxFreq=0;
        int maxLength=0;
        HashMap<Character, Integer> map=new HashMap<>();
        while(r<s.length()){
            char rChar=s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar,0)+1);
            maxFreq=Math.max(map.get(rChar), maxFreq);
            while(r-l+1-maxFreq>k){
                char lChar=s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar,0)-1);
                for(char key: map.keySet()){
                    maxFreq=Math.max(map.get(key), maxFreq);
                }
                l++;
            }
            maxLength=Math.max(r-l+1, maxLength);
            r++;
        }
        return maxLength;
    }
}