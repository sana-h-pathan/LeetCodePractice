class Solution {
    public int characterReplacement(String s, int k) {
        int slow=0;
        int fast=0;
        HashMap<Character, Integer> map=new HashMap<>();
        int maxFreq=0;
        int maxLength=0;
        while(fast<s.length()){
            char fChar=s.charAt(fast);
            map.put(fChar, map.getOrDefault(fChar, 0)+1);
            maxFreq=Math.max(maxFreq, map.get(fChar));
            while(fast-slow+1-maxFreq>k){
                char sChar=s.charAt(slow);
                map.put(sChar, map.getOrDefault(sChar, 0)-1);
                for(Character ch: map.keySet())
                   maxFreq=Math.max(maxFreq, map.get(ch)); 
                slow++;
            }
            maxLength=Math.max(fast-slow+1, maxLength);
            fast++;
        }
        return maxLength;
    }
}