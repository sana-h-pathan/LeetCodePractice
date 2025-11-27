class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int l=0;
        int r=0;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<p.length();i++){
            char pChar=p.charAt(i);
            map.put(pChar, map.getOrDefault(pChar, 0)+1);
        }
        int matches=0;
        while(r<s.length()){
            char rChar=s.charAt(r);
            if(map.containsKey(rChar)){
                map.put(rChar, map.getOrDefault(rChar, 0)-1);
                if(map.get(rChar)==0)
                    matches++;
            }
            if(r>=p.length()){
                char lChar=s.charAt(l);
                if(map.containsKey(lChar)){
                    map.put(lChar,map.getOrDefault(lChar,0)+1);
                    if(map.get(lChar)==1)
                        matches--;
                }
                l++;
            }
            if(map.size()==matches)
                result.add(l);
            r++;
        }
        return result;
    }
}