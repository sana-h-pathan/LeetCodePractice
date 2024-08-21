class Solution {

    public int strangePrinter(String s) {
        s = removeDuplicates(s);
        int n = s.length();
        int[][] minTurns = new int[n][n];

        for (int i = 0; i < n; i++) {
            minTurns[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j + i - 1 < n; j++) {
                int sub = j + i - 1;

                // Initialize with worst case: print each character separately
                minTurns[j][sub] = i;

                // Try all possible splits and find the minimum
                for (int split = 0; split < i - 1; split++) {
                    int totalTurns =
                        minTurns[j][j + split] +
                        minTurns[j + split + 1][sub];

                    // If the characters at the split and sub match, we can save one turn
                    if (s.charAt(j + split) == s.charAt(sub)) {
                        totalTurns--;
                    }

                    minTurns[j][sub] = Math.min(
                        minTurns[j][sub],
                        totalTurns
                    );
                }
            }
        }

        // Return the minimum turns needed to print the entire string
        return minTurns[0][n - 1];
    }

    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            // Skip all consecutive occurrences of the current character
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}