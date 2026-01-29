class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int count = 0;
        int i = 1;
        while (i<word.length()) {
            if (Math.abs(word.charAt(i) - word.charAt(i-1))<=1) {
                count++;
                i += 2;   // skip next because we "fixed" one char in this pair
            } else {
                i++;
            }
        }
        return count;
    }

}