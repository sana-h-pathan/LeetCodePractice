class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int reqdMatch=t.length();
        int currMatch=0;
        int l=0;
        int r=0;
        int sIdx=-1;
        int minLength=Integer.MAX_VALUE;
        while(r<s.length()){
            char rChar=s.charAt(r);
            if(map.getOrDefault(rChar,0)>0){
                currMatch++;
            }
            map.put(rChar, map.getOrDefault(rChar,0)-1);
            while(currMatch==reqdMatch){
                if(r-l+1<minLength){
                    minLength=r-l+1;
                    sIdx=l;
                }
                char lChar=s.charAt(l);
                map.put(lChar,map.getOrDefault(lChar,0)+1);
                if(map.getOrDefault(lChar,0)>0){
                    currMatch--;
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