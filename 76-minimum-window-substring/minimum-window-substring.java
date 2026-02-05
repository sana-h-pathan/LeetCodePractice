class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null|| s.length()<t.length()){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int currMatches=0;
        int reqdMatches = t.length();
        int l=0;
        int r=0;
        int sIdx=-1;
        int minLength=Integer.MAX_VALUE;
        while(r<s.length()){
            char rChar = s.charAt(r);
            if(map.containsKey(rChar)){
                if(map.get(rChar)>0){
                    currMatches++;
                }
                map.put(rChar, map.get(rChar)-1);
            }
            while(currMatches==reqdMatches){
                if(minLength>r-l+1){
                    sIdx=l;
                    minLength = r-l+1;
                }
                char lChar = s.charAt(l);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.get(lChar)+1);
                    if(map.get(lChar)>0){
                        currMatches--;
                    }
                }
                l++;
            }
            r++;
        }
        return sIdx==-1?"":s.substring(sIdx, sIdx+minLength);
    }
}