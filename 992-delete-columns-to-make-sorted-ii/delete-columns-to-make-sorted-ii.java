class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int w = strs[0].length();
        // cuts[j] is true : we don't need to check any new A[i][j] <= A[i][j+1]
        boolean[] cuts = new boolean[n-1];

        int ans = 0;
        search: for (int j = 0; j < w; ++j) {
            // Evaluate whether we can keep this column
            for (int i = 0; i < n-1; ++i)
                if (!cuts[i] && strs[i].charAt(j) > strs[i+1].charAt(j)) {
                    // Can't keep the column - delete and continue
                    ans++;
                    continue search;
                }

            // Update 'cuts' information
            for (int i = 0; i < n-1; ++i)
                if (strs[i].charAt(j) < strs[i+1].charAt(j))
                    cuts[i] = true;
        }

        return ans;
    }
}
