class Solution {
    public String robotWithString(String s) {
        Stack<Character> stk = new Stack<>();
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char minChar = 'a';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stk.push(ch);
            freq[ch - 'a']--;

            while (minChar <= 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }

            while (!stk.isEmpty() && stk.peek() <= minChar) {
                sb.append(stk.pop());
            }
        }

        while (!stk.isEmpty()) sb.append(stk.pop());
        return sb.toString();
    }
}
