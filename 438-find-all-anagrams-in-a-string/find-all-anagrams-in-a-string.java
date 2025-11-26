class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int r=0;
        int l=0;
        int sLength=s.length();
        int pLength=p.length();
        HashMap<Character, Integer> pMap=new HashMap<>();
        for(int i=0;i<pLength;i++){
            char c=p.charAt(i);
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        int match=0;
        while(r<sLength){
            //process the incoming character
            char in=s.charAt(r);
            if(pMap.containsKey(in)){
                pMap.put(in,pMap.getOrDefault(in,0)-1);
                if(pMap.get(in)==0)
                    match++;
            }
            //process the outgoing character when i becomes greater than plength
            if(r>=pLength){
                char out=s.charAt(l);
                if(pMap.containsKey(out)){
                    pMap.put(out,pMap.getOrDefault(out,0)+1);
                    if(pMap.get(out)==1)
                        match--;
                }
                l++;
            }
            if(match==pMap.size())
                result.add(l);
            r++;
        }
        return result;
    }
}