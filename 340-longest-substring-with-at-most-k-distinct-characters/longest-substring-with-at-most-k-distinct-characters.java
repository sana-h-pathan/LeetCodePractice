class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLength= 1;
        int n = s.length();
        if(n==0 || k ==0)
            return 0;
        int left = 0;
        int right = 0;
        
        Map<Character,Integer> map = new HashMap<>();
        while(right < n){
            Character ch = s.charAt(right);
            map.put(ch, right);
            right++;
            if(map.size() ==k+1){
                int leftMostIndex = Collections.min(map.values());
                map.remove(s.charAt(leftMostIndex)); 
                left = leftMostIndex+1;
            }
            maxLength = Math.max(maxLength,right -left);
        }
        return maxLength;
    }
}