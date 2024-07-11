class Solution {
    public boolean isMatchRec(String s, String p) {
        int m=s.length();
        int n=p.length();
        return helper(m-1, n-1,s,p);
    }

    private boolean helper(int i, int j, String s, String p){
        if(i<0 && j<0)
            return true;
        if(i>=0 && j<0)
            return false;
        if(i<0 && j>=0){
            for(int k=j;k>=0;k--)
                if(p.charAt(k)!='*')
                    return false;
            return true;
        }
        if(s.charAt(i)==p.charAt(j)|| p.charAt(j)=='?')
            helper(i-1, j-1, s, p);
        else if(p.charAt(j)=='*'){
            return helper(i-1, j, s, p) || helper(i, j-1, s, p);
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='?')
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}