class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l =0;
        int r =0;
        int matches=0;
        int sIdx = -1;
        int minLength=Integer.MAX_VALUE;
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        while(r<s.length()){
            char rChar = s.charAt(r);
            if(map.containsKey(rChar)){
                if(map.get(rChar)>0){
                    matches++;
                }
                map.put(rChar, map.getOrDefault(rChar, 0)-1);
            }
            while(matches==t.length()){
                if(minLength>r-l+1){
                    sIdx = l;
                    minLength = Math.min(minLength, r-l+1);
                }
                char lChar = s.charAt(l);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.getOrDefault(lChar, 0)+1);
                    if(map.get(lChar)>0){
                        matches--;
                    }
                }
                l++;
            }
            r++;
        }
        if(sIdx==-1){
            return "";
        }
        return s.substring(sIdx, sIdx+minLength);
    }
}