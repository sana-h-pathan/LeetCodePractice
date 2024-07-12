class Solution {

    public int maximumGain(String s, int x, int y) {
        StringBuilder text = new StringBuilder(s);
        int totalPoints = 0;

        if (x > y) {
            // Remove "ab" first (higher points), then "ba"
            totalPoints += removeSubstring(text, "ab", x);
            totalPoints += removeSubstring(text, "ba", y);
        } else {
            // Remove "ba" first (higher or equal points), then "ab"
            totalPoints += removeSubstring(text, "ba", y);
            totalPoints += removeSubstring(text, "ab", x);
        }

        return totalPoints;
    }

    private int removeSubstring(StringBuilder s,String t,int pts) {
        int totalPoints = 0;
        int l=0;
        int r=0;
        while (r<s.length()) {
            s.setCharAt(l++, s.charAt(r));
            //if(l>1&&s.substring(l-2,l).equals(t)){
            if (l>1 && s.charAt(l - 2) == t.charAt(0) && s.charAt(l - 1) == t.charAt(1)) {
                l -= 2; 
                totalPoints += pts;
            }
            r++;
        }
        s.setLength(l);
        return totalPoints;
    }
}