class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        int count=0;
        for(char c: t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        int reqdCount=t.length();
        int currCount=0;
        int length=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        int sIdx=-1;
        while(r<s.length()){
            char ch=s.charAt(r);
            if(map.getOrDefault(ch,0)>0)
                currCount++;
            map.put(ch, map.getOrDefault(ch, 0)-1);
            while(currCount==reqdCount){
                if(r-l+1<length){
                    length=r-l+1;
                    sIdx=l;
                }
                char lChar=s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar, 0)+1);
                if(map.get(lChar)>0)
                    currCount--;
                l++;
            }
            r++;
        }
        if(sIdx==-1)
            return "";
        return s.substring(sIdx ,sIdx+length);
    }
}