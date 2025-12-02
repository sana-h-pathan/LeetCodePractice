class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        for(int i=0;i<t.length();i++){
            char tChar=t.charAt(i);
            map.put(tChar, map.getOrDefault(tChar, 0)+1);
        }
        int currMatches=0;
        int reqdMatches=t.length();
        int sIdx=-1;
        int minLength=Integer.MAX_VALUE;
        while(r<s.length()){
            char rChar=s.charAt(r);
            if(map.getOrDefault(rChar,0)>0)
                currMatches++;
            map.put(rChar, map.getOrDefault(rChar,0)-1);
            while(currMatches==reqdMatches){
                if(minLength>r-l+1){
                    sIdx=l;
                    minLength=r-l+1;
                }
                char lChar=s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)+1);
                if(map.getOrDefault(lChar,0)>0){
                    currMatches--;
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