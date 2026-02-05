class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) 
            return 0;

        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int arrows = 1;
        long arrowPos = points[0][1]; // arrow at first balloon end

        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (curr[0] > arrowPos) {   // no overlap -> need new arrow
                arrows++;
                arrowPos = curr[1];
            }
            // else overlap -> same arrow works, do nothing
        }
        return arrows;
    }
}
