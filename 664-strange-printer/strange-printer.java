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
                minTurns[j][sub] = i;
                for (int k = 0; k < i - 1; k++) {
                    int totalTurns = minTurns[j][j + k] + minTurns[j + k + 1][sub];
                    if (s.charAt(j + k) == s.charAt(sub)) 
                        totalTurns--;
                    
                    minTurns[j][sub] = Math.min(
                        minTurns[j][sub],
                        totalTurns
                    );
                }
            }
        }
        return minTurns[0][n - 1];
    }

    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}