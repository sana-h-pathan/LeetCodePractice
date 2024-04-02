class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int left = 0, right = 0;
        int n = s.length();
        
        if(n < 3)
            return n;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 2;
        int index = 0;
        while(right < n) {
            
            if(map.size() <=2) {
                char ch = s.charAt(right);
                map.put(ch, right);
                right++;
            }
            
            if(map.size() == 3){ 
                
                index = Collections.min(map.values());
               
                /*for(int num: map.values()) {
                    if(num < index)
                        index = num;
                   // index = Math.min(index,num);
                }*/
                
                map.remove(s.charAt(index));
                left = index+1;
            }
            
            maxLength = Math.max(maxLength, right - left);
            
        }
        
        return maxLength;
    }
}