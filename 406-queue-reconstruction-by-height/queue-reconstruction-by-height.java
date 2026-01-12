//time = o(nlogn) + o(n^2)
// space = o(n)

// using greedy algorithm

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        
        List<int[]> output = new ArrayList<>();
        for(int[] p : people) {
            output.add(p[1], p);
        }
        
        return output.toArray(new int[people.length][2]);
    }
}