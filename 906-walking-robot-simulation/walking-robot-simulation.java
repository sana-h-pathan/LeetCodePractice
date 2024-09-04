class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int dir = 0;
        int maxDist = 0;

        for (int com : commands) {
            if (com == -1) {
                dir = (dir + 1) % 4;
            } else if (com == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < com; i++) {
                    int newX = x + dirs[dir][0];
                    int newY = y + dirs[dir][1];
                    if (!obstacleSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxDist = Math.max(maxDist, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }

        return maxDist;
    }
}