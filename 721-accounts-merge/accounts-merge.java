
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // email -> index
        HashMap<String, Integer> idMap = new HashMap<>();
        // email -> name
        HashMap<String, String> nameMap = new HashMap<>();

        int id = 0;
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!idMap.containsKey(email)) {
                    idMap.put(email, id++);
                }
                nameMap.put(email, name);
            }
        }

        UnionFind uf = new UnionFind(id);

        // union emails in same account
        for (List<String> acc : accounts) {
            if (acc.size() <= 2) 
                continue; // only 1 email, no union needed
            int firstId = idMap.get(acc.get(1));
            for (int i = 2; i < acc.size(); i++) {
                int nextId = idMap.get(acc.get(i));
                uf.union(firstId, nextId);
            }
        }

        // root -> list of emails
        HashMap<Integer, List<String>> groups = new HashMap<>();
        for (String email : idMap.keySet()) {
            int root = uf.find(idMap.get(email));
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            String name = nameMap.get(emails.get(0));
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);
            res.add(merged);
        }

        return res;
    }

    class UnionFind {
        int[] parent;
        int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
            return true;
        }
    }
}
