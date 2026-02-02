class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] memo = new int[n][4]; // lanes 1..3
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }

        return helper(0, 2, obstacles, memo);
    }

    private int helper(int pos, int lane, int[] obs, int[][] memo) {
        int n = obs.length;
        if (pos==obs.length-1) 
            return 0;

        if (memo[pos][lane]!=-1) 
            return memo[pos][lane];

        // move forward if possible
        if (obs[pos + 1]!=lane) {
            memo[pos][lane] = helper(pos+1, lane, obs, memo);
            return memo[pos][lane];
        }

        // forward blocked -> side jump
        int result = Integer.MAX_VALUE/10;
        for (int newLane = 1;newLane<=3;newLane++) {
            if (newLane == lane) 
                continue;
            if (obs[pos]!=newLane) {
                result = Math.min(result, 1+helper(pos, newLane, obs, memo));
            }
        }

        memo[pos][lane] = result;
        return result;
    }





    public int minSideJumps2(int[] obstacles) {
        return helper(0, 2, obstacles);
    }

    private int helper(int idx, int lane, int[] obs) {
        if (idx==obs.length-1) 
            return 0;

        // if forward is not blocked, go forward with 0 cost
        if (idx+1<obs.length && obs[idx+1]!=lane) {
            return helper(idx+1, lane, obs);
        }

        // forward blocked => must side jump
        int result = Integer.MAX_VALUE / 2;
        for (int newLane=1;newLane<=3;newLane++) {
            if(newLane == lane) 
                continue;
            // can only jump to a lane that is not blocked at current pos
            if (obs[idx] != newLane) {
                result = Math.min(result, 1+helper(idx, newLane, obs));
            }
        }
        return result;
    }
}
