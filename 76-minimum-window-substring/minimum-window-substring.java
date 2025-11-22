class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int reqdCount=t.length();
        int currCount=0;
        int l=0;
        int r=0;
        int sIdx=-1;
        int maxLength=Integer.MAX_VALUE;
        while(r<s.length()){
            char rChar=s.charAt(r);
            if(map.getOrDefault(rChar,0)>0){
                currCount++; 
            }
            map.put(rChar, map.getOrDefault(rChar, 0)-1);
            while(currCount==reqdCount){
                if(r-l+1<maxLength){
                    sIdx=l;
                    maxLength=r-l+1;
                }
                char lChar=s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)+1);
                if(map.getOrDefault(lChar,0)>0)
                      currCount--; 
                l++;
            }
            r++;
        }
        if(sIdx==-1)
            return "";
        return s.substring(sIdx, sIdx+maxLength);

    }
}