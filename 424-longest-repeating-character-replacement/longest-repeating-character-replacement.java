class Solution {
    public int characterReplacement(String s, int k) {
        int slow=0;
        int fast=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int maxFreq=0;
        int maxLength=0;
        while(fast<s.length()){
            char ch=s.charAt(fast);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq, map.get(ch));
            if(fast-slow+1-maxFreq>k){
                char sChar=s.charAt(slow);
                map.put(sChar, map.getOrDefault(sChar,0)-1);
                maxFreq=0;
                for(Character key: map.keySet()){
                    maxFreq=Math.max(maxFreq, map.get(key));
                }
                slow++;
            }
            maxLength=Math.max(maxLength, fast-slow+1);
            fast++;
        }
        return maxLength;
    }
}