class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int maxFreq=0;
        int maxLength=0;
        HashMap<Character, Integer> map=new HashMap<>();
        while(r<s.length()){
            char c=s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFreq=Integer.max(maxFreq, map.get(c));
           // int currLen=r-l+1;
            while(r-l+1-maxFreq>k){
                char ch=s.charAt(l);
                map.put(ch, map.getOrDefault(ch, 0)-1);
                maxFreq=0;
                for(Character chr: map.keySet()){
                    maxFreq=Math.max(map.get(chr),maxFreq);
                }
                l++;
            }
            /*if (r - l + 1 - maxFreq > k) {
                char ch = s.charAt(l);
                map.put(ch, map.get(ch) - 1);
                l++;
            }*/
            if(r-l+1-maxFreq<=k){
                maxLength=Integer.max(maxLength, r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}