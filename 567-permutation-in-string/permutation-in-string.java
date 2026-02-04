class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s1.length()>s2.length()){
            return false;
        }
        for(char ch: s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int l=0;
        int r=0;
        int matches=0;
        while(r<s2.length()){
            char rChar = s2.charAt(r);
            if(map.containsKey(rChar)){
                map.put(rChar, map.getOrDefault(rChar, 0)-1);
                if(map.get(rChar)==0){
                    matches++;
                }
            }
            if(r>=s1.length()){
                char lChar = s2.charAt(l);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.getOrDefault(lChar, 0)+1);
                    if(map.get(lChar)==1){
                        matches--;
                    }
                }
                l++;
            }
            if(matches==map.size()){
                return true;
            }
            r++;
        }
        return false;
    }
}