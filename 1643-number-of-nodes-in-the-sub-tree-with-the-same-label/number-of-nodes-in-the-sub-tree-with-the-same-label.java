class Solution {
        public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int e0=e[0];
            int e1=e[1];
            if(!map.containsKey(e0))
                map.put(e0, new ArrayList<>());
            if(!map.containsKey(e1))
                map.put(e1, new ArrayList<>());
            map.get(e0).add(e1);
            map.get(e1).add(e0);
        }
        int[] result = new int[n];
        Set<Integer> seen = new HashSet<>();
        dfs(map, 0, labels, result, seen);
        return result;
    }
    private int[] dfs(Map<Integer, List<Integer>> map, int node, String labels, int[] ans, Set<Integer> seen) {
        int[] cnt = new int[26];
        if (seen.add(node)) {
            char c = labels.charAt(node);
            for (int child : map.getOrDefault(node, Collections.emptyList())) {
                int[] sub = dfs(map, child, labels, ans, seen);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += sub[i];
                }
            }
            ++cnt[c - 'a'];
            ans[node] = cnt[c - 'a'];
        }
        return cnt;
    }
}