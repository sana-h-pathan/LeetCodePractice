class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int maxLen=0;
         while(r<s.length()){
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>k){
                char ch=s.charAt(l);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==0)
                    map.remove(ch);
                l++;
            }
            int len=r-l+1;
            maxLen=Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
}