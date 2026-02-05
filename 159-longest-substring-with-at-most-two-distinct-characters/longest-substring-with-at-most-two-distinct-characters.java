class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) { 
        if(s.length() < 3)
            return s.length();
        
        if(s==null || s.length()==0 ){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        int maxLength=0;
        while(r<s.length()){
            char rChar = s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0)+1);
            if(map.size()>2){
                char lChar = s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)-1);
                if(map.get(lChar)==0){
                    map.remove(lChar, 0);
                }
                l++;
            }
            maxLength=Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}