class Solution {

    public long maximumImportance(int n, int[][] roads) {
        long[] inDegree = new long[n];

        for (int[] road : roads) {
            inDegree[road[0]]++;
            inDegree[road[1]]++;
        }

        Arrays.sort(inDegree);

        long count = 1;
        long result = 0;
        for (long degree : inDegree) {
            result += (count * degree);
            count++;
        }

        return result;
    }
}