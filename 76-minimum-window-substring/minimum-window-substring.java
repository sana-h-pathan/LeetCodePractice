class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        HashMap<Character, Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int sIdx=-1;
        int minLength=Integer.MAX_VALUE;
        int currMatch=0;
        for(int i=0;i<t.length();i++){
            char tChar=t.charAt(i);
            map.put(tChar, map.getOrDefault(tChar,0)+1);
        }
        int reqdMatch=t.length();
        while(r<s.length()){
            char rChar=s.charAt(r);
            if(map.getOrDefault(rChar, 0)>0){
                currMatch++;
            }
            map.put(rChar, map.getOrDefault(rChar,0)-1);
            while(currMatch==reqdMatch){
                char lChar=s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar,0)+1);
                if(map.getOrDefault(lChar,0)>0){
                    currMatch--;
                }
                if(minLength>r-l+1){
                    minLength=r-l+1;
                    sIdx=l;
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