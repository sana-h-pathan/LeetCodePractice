package practice.medium;

public class LongestPalindromeString {

    public static void main(String[] args) {
        LongestPalindromeString lps=new LongestPalindromeString();
        System.out.println(lps.longestPalindrome("abab"));
    }

    int maxLen;
    int start = 0, end = 0;

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";

        for(int i=0; i<s.length(); i++) {
            checkForLongestPalindrome(s, i, i);
            checkForLongestPalindrome(s, i, i+1);
        }

        return s.substring(start, end+1);
    }

    private void checkForLongestPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;

        if(maxLen < right-left+1) {
            maxLen = right-left+1;
            start = left;
            end = right;
        }
    }
}
