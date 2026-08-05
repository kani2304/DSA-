class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        boolean[] suspicious = new boolean[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : invocations) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        dfs(k, graph, suspicious, indegree);
        for (int i = 0; i < n; i++) {
            if (suspicious[i] && indegree[i] > 0) {
                List<Integer> all = new ArrayList<>();
                for (int j = 0; j < n; j++) all.add(j);
                return all;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) ans.add(i);
        }
        return ans;
    }
    private void dfs(int u, List<Integer>[] graph, boolean[] suspicious, int[] indegree) {
        if (suspicious[u]) return;
        suspicious[u] = true;
        for (int v : graph[u]) {
            indegree[v]--;
            dfs(v, graph, suspicious, indegree);
        }
    }
}