class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxLength=0;
        HashMap<Character, Integer> map=new HashMap<>();
        while (r<s.length()) {
            char currChar=s.charAt(r);
            if(map.containsKey(currChar)){
                if(map.get(currChar)>=l)
                    l=map.get(currChar)+1;
            }
            map.put(currChar, r);
            int currLength=r-l+1;
            maxLength=Integer.max(currLength, maxLength);
            r++;
        }
        return maxLength;
    }
}