class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        visited.add(x);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int num = curr[0];
            int turn = curr[1];

            if (num == y) {
                return turn;
            }

            if (!visited.contains(num + 1)) {
                q.add(new int[]{num + 1, turn + 1});
                visited.add(num + 1);
            }

            if (num - 1 >= 0 && !visited.contains(num - 1)) {
                q.add(new int[]{num - 1, turn + 1});
                visited.add(num - 1);
            }

            if (num % 11 == 0 && !visited.contains(num / 11)) {
                q.add(new int[]{num / 11, turn + 1});
                visited.add(num / 11);
            }

            if (num % 5 == 0 && !visited.contains(num / 5)) {
                q.add(new int[]{num / 5, turn + 1});
                visited.add(num / 5);
            }
        }

        return -1;
    }
}