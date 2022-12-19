package practice.medium;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, count = 0;
        HashSet<Character> charSet = new HashSet<>();
        while (j < s.length()) {
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++));
                count = Integer.max(count, charSet.size());
            } else
                charSet.remove(s.charAt(i++));
        }
        return count;
    }
        public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring=new LengthOfLongestSubstring();
            System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abbcdaedabc"));
    }

}
