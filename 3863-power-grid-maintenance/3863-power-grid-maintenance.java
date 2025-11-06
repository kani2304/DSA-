class Solution {
    public int parent [];
    public int rank [];
    public void init(int c) {
        parent = new int[c];
        rank = new int[c];
        for (int i=0; i<c; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa;
            rank[pb]++;
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        init(c+1);
        for (int i=0; i<connections.length; i++) {
            union(connections[i][0], connections[i][1]);
        }
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i=0; i<=c; i++) {
            int x = find(i);
            if (!map.containsKey(x)) {
                map.put(x, new TreeSet<>());
            }
        }
        for (int i=0; i<=c; i++) {
            int x = find(i);
            map.get(x).add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int p = find(y);
            if (x == 2) {
                map.get(p).remove(y);
            }
            else {
                if (map.get(p).contains(y)) {
                    list.add(y);
                }
                else if (map.get(p).isEmpty()) {
                    list.add(-1);
                }
                else {
                    list.add(map.get(p).first());
                }
            }
        }
        int ans [] = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}