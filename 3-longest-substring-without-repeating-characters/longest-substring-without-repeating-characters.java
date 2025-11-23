class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow=0;
        int fast=0;
        HashMap<Character, Integer> map=new HashMap<>();
        int maxLength=0;
        while(fast<s.length()){
            char fChar=s.charAt(fast);
            if(map.containsKey(fChar)){
                if(map.get(fChar)>=slow){
                    slow=map.get(fChar)+1;
                }
            }
            map.put(fChar, fast);
            int currLength=fast-slow+1;
            maxLength=Math.max(currLength, maxLength);
            fast++;
        }
        return maxLength;
    }
}