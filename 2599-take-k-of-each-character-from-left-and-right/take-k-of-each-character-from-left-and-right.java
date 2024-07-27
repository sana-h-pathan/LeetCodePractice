class Solution {
    public int takeCharacters(String s, int k) {
        // edge cases
        int n = s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        if (map.getOrDefault('a', 0) < k || map.getOrDefault('b', 0) < k || map.getOrDefault('c', 0) < k) 
            return -1;
        int result = n;
        int l=0;
        int r=0;
        while(r<n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0)-1);
            while (map.get(ch) < k) {
                char lChar = s.charAt(l);
                map.put(lChar, map.getOrDefault(lChar,0)+1);
                l++;
            }
            result = Math.min(result, n - (r - l + 1));
            r++;
        }
        return result;
    }
}