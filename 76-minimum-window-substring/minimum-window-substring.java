class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int currMatch=0;
        int reqdMatch=t.length();
        int maxLength=Integer.MAX_VALUE;
        int sIdx=-1;
        int l=0;
        int r=0;
        while(r<s.length()){
            char rChar=s.charAt(r);
            if(map.getOrDefault(rChar,0)>0)
               currMatch++;
            map.put(rChar,map.getOrDefault(rChar,0)-1);
            while(currMatch==reqdMatch){
                if(r-l+1<maxLength){
                    sIdx=l;
                    maxLength=r-l+1;
                }
                char lChar=s.charAt(l);
                map.put(lChar,map.getOrDefault(lChar,0)+1);
                if(map.getOrDefault(lChar,0)>0)
                    currMatch--;
                l++;
            }
            r++;
        }
        if(sIdx==-1)
            return "";
        return s.substring(sIdx, sIdx+maxLength);
    }
}