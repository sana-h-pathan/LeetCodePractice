class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || t.length()>s.length()){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int l=0;
        int r=0;
        int currMatches = t.length();
        int reqdMatches = 0;
        int minLength = Integer.MAX_VALUE;
        int sIdx = -1;
        while(r<s.length()){
            char rChar = s.charAt(r);
            if(map.containsKey(rChar)){
                if(map.get(rChar)>0){
                    reqdMatches++;
                }
                map.put(rChar, map.getOrDefault(rChar, 0)-1);
            }
            while(currMatches==reqdMatches){
                if(minLength>r-l+1){
                    minLength = r-l+1;
                    sIdx = l;
                }
                char lChar = s.charAt(l);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.getOrDefault(lChar, 0)+1);
                    if(map.get(lChar)>0){
                        reqdMatches--;
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