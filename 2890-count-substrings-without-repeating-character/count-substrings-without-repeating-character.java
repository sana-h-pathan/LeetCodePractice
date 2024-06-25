class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int ans = 0;
        int right = 0;
        int left = 0;
        int[] arr = new int[26];
        while(right < s.length()){
            if(arr[s.charAt(right) - 'a'] == 0){
                arr[s.charAt(right) - 'a']++;
            } else {
                while(arr[s.charAt(right) - 'a'] != 0) {
                    arr[s.charAt(left) - 'a']--;
                    left++;
                }
                arr[s.charAt(right) - 'a']++;
            }
            ans += (right - left + 1);
            right++;
        }
        return ans;
    }
}