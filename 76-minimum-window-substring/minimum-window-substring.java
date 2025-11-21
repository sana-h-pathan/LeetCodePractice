class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int slow=0;
        int fast=0;
        int reqdCount=t.length();
        int currCount=0;
        int sIdx=-1;
        int minLength=Integer.MAX_VALUE;
        while(fast<s.length()){
            char fChar=s.charAt(fast);
            if(map.getOrDefault(fChar,0)>0){
                currCount++;
            }
            map.put(fChar, map.getOrDefault(fChar,0)-1);
            while(currCount==reqdCount){
                if(fast-slow+1<minLength){
                    minLength=fast-slow+1;
                    sIdx=slow;
                }
                char lChar=s.charAt(slow);
                map.put(lChar, map.getOrDefault(lChar,0)+1);
                if(map.getOrDefault(lChar,0)>0){
                    currCount--;
                }
                slow++;
            }
            fast++;
        }
        if(sIdx==-1)
            return "";
        return s.substring(sIdx,sIdx+minLength);
    }
}