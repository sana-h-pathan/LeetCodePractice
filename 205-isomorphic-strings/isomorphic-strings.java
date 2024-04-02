class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==0 && t.length()==0)
            return true;
        if(s==null || t==null)
            return false;
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Character> sToT=new HashMap<>();
        HashMap<Character,Character> tToS=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char ch1=t.charAt(i);
            if(sToT.containsKey(ch)){
                if(sToT.get(ch)!=ch1)
                    return false;
            }
            else{
                sToT.put(ch, ch1);
            }
            if(tToS.containsKey(ch1)){
                if(tToS.get(ch1)!=ch)
                    return false;
            }
            else{
                tToS.put(ch1, ch);
            }

        }
        return true;
    }
}