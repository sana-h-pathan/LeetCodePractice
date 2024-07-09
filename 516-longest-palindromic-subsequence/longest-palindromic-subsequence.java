class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] lcs=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if (s.charAt(i-1) == s2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                else {
                    lcs[i][j]=Math.max(lcs[i][j-1],lcs[i-1][j]);
                }
            }
        }
        return lcs[n][n];
    }
}