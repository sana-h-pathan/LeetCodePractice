class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq=0;
        int maxLength=0;
        int l=0;
        int r=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            char rChar=s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0)+1);
            maxFreq=Math.max(maxFreq, map.get(rChar));
            while(r-l+1-maxFreq>k){
                char lChar=s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)-1);
                maxFreq=0;
                for(Character ch: map.keySet()){
                    maxFreq=Math.max(maxFreq, map.get(ch));
                }
                l++;
            }
            int currLength=(r-l+1);
            maxLength=Math.max(currLength, maxLength);
            r++;
        }
        return maxLength;
    }
}