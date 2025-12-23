class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int currentMatches = t.length();
        int reqdMatches = 0;
        int sIdx=-1;
        int l=0;
        int r=0;
        int minLength = Integer.MAX_VALUE;
        while(r<s.length()){
            char rChar = s.charAt(r);
            if(map.getOrDefault(rChar,0)>0){
                reqdMatches++;
            }
            map.put(rChar, map.getOrDefault(rChar, 0)-1);
            while(reqdMatches==currentMatches){
                if(r-l+1<minLength){
                    minLength = Math.min(r-l+1, minLength);
                    sIdx=l;
                }
                char lChar = s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)+1);
                if(map.getOrDefault(lChar, 0)>0){
                    reqdMatches--;
                }
                l++; 
            }
            r++;
        }
        if(sIdx==-1)
            return "";
        return s.substring(sIdx, sIdx+minLength);
    }
}