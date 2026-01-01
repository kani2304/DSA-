class Solution {

    private void dfs(int u, int[] present, int[] future, List<Integer>[] adj, int[][][] statesprofit, int budget){
        //childrenstatesprofit:
        //childnotbuy[i] -> profit if parent NOT bought
        //childbuy[i] -> profit if parent IS bought

        List<int[][]> childrenstatesprofit = new ArrayList<>();

        //process children first
        for (int v : adj[u]){
            dfs(v, present, future, adj, statesprofit, budget);
            childrenstatesprofit.add(
                new int[][]{ statesprofit[v][0], statesprofit[v][1] }
            );
        }

        //parentbought = 0 or 1
        for (int parentbought = 0; parentbought <= 1; parentbought++){

            int price = (parentbought == 1) ? present[u] / 2 : present[u];
            int profit = future[u] - price;

            int[] bestprofitatU = new int[budget + 1];

            //case 1 -> do NOT buy node u
            int[] childrenprofitIfUnotbought = new int[budget + 1];

            for (int[][] child : childrenstatesprofit){
                int[] childnotbuy = child[0];
                int[] temp = new int[budget + 1];

                for (int used = 0; used <= budget; used++){
                    for (int take = 0; used + take <= budget; take++){
                        temp[used + take] = Math.max(
                            temp[used + take],
                            childrenprofitIfUnotbought[used] + childnotbuy[take]
                        );
                    }
                }
                childrenprofitIfUnotbought = temp;
            }

            for (int b = 0; b <= budget; b++){
                bestprofitatU[b] = Math.max(bestprofitatU[b], childrenprofitIfUnotbought[b]);
            }

            //case 2 -> buy node u
            if (price <= budget){
                int[] childrenprofitifUbought = new int[budget + 1];

                for (int[][] child : childrenstatesprofit){
                    int[] childbuy = child[1];
                    int[] temp = new int[budget + 1];

                    for (int used = 0; used <= budget; used++){
                        for (int take = 0; used + take <= budget; take++){
                            temp[used + take] = Math.max(
                                temp[used + take],
                                childrenprofitifUbought[used] + childbuy[take]
                            );
                        }
                    }
                    childrenprofitifUbought = temp;
                }

                for (int b = price; b <= budget; b++){
                    bestprofitatU[b] = Math.max(
                        bestprofitatU[b],
                        childrenprofitifUbought[b - price] + profit
                    );
                }
            }

            statesprofit[u][parentbought] = bestprofitatU;
        }
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget){
        //building adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] h : hierarchy){
            int u = h[0] - 1;
            int v = h[1] - 1;
            adj[u].add(v);
        }

        //statesprofit[u][0][b] -> parent NOT bought
        //statesprofit[u][1][b] -> parent BOUGHT
        int[][][] statesprofit = new int[n][2][budget + 1];

        dfs(0, present, future, adj, statesprofit, budget);

        int ans = 0;
        for (int b = 0; b <= budget; b++){
            ans = Math.max(ans, statesprofit[0][0][b]);
        }
        return ans;
    }
}