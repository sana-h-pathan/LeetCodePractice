class Solution {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        // Initialize dp arrays
        int[][] dpPrev = new int[2][3]; // previous state
        int[][] dpCurr = new int[2][3]; // current state

        dpPrev[0][0] = 1; // empty string

        for (int i = 0; i < n; i++) {
            for (int count = 0; count < 2; count++) {
                for (int countLen = 0; countLen < 3; countLen++) {
                    // choose "P"
                    dpCurr[count][0] = (dpCurr[count][0] + dpPrev[count][countLen]) % MOD;
                    // choose "A"
                    if (count == 0) {
                        dpCurr[count + 1][0] = (dpCurr[count + 1][0] + dpPrev[count][countLen]) % MOD;
                    }
                    // Choose "L"
                    if (countLen < 2) {
                        dpCurr[count][countLen + 1] = (dpCurr[count][countLen + 1] + dpPrev[count][countLen]) % MOD;
                    }
                }
            }
            dpPrev = dpCurr; // Reference current to previous
            dpCurr = new int[2][3]; // make new current
        }

        // Sum up the counts for all combinations of length 'n' with different count and countLen.
        int res = 0;
        for (int count = 0; count < 2; count++) {
            for (int countLen = 0; countLen < 3; countLen++) {
                res = (res + dpPrev[count][countLen]) % MOD;
            }
        }
        return res;
    }
}