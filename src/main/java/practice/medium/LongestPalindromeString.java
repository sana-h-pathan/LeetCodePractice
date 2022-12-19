package practice.medium;

public class LongestPalindromeString {

    public static void main(String[] args) {
        LongestPalindromeString lps=new LongestPalindromeString();
        System.out.println(lps.longestPalindrome("abab"));
    }

    private String  longestPalindrome(String s) {
        if(s.length()<1 || s==null)
            return "";

        int start=0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromMiddle(String s, int left, int right) {
        if(left>right || s==null)
            return 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
