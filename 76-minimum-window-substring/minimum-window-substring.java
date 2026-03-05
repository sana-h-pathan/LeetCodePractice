class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length()){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int minLength = Integer.MAX_VALUE;
        int sIdx = -1;
        int l = 0;
        int r = 0;
        int currentMatches = t.length();
        int reqdMatched = 0;
        while(r<s.length()){
            char rChar = s.charAt(r);
            if(map.containsKey(rChar)){
                if(map.get(rChar)>0){
                    reqdMatched++;
                }
                map.put(rChar, map.getOrDefault(rChar, 0)-1);
            }
            while(currentMatches==reqdMatched){
                if(minLength>r-l+1){
                    minLength = r-l+1;
                    sIdx = l;
                }
                char lChar = s.charAt(l);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.getOrDefault(lChar, 0)+1);
                    if(map.get(lChar)>0){
                        reqdMatched--;
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