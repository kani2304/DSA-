class Solution {
    int MOD = 1000000007;
    public int numberOfSets(int n, int k) {
        int[][][] dp = new int[n+1][k+1][3];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return countWays(n , k , 0 , dp);
    }
    public int countWays(int n , int k , int count , int[][][] dp) {
        if (k == 0) {return 1;}
        if (n == 0) {return 0;}
        if (dp[n][k][count] != -1) {return dp[n][k][count];}
        if (count == 0) {
            int take = countWays(n-1 , k , count+1 , dp);
            int notTake = countWays(n-1 , k , count , dp);
            return dp[n][k][count] = (take + notTake)% MOD;
        }
        if (count == 1) {
            int end = countWays(n , k-1 , 0 , dp);
            int move = countWays(n-1 , k , count+1 , dp);
            return dp[n][k][count] = (end + move) % MOD;
        }
        int end = countWays(n , k-1 , 0 , dp);
        int move = countWays(n-1 , k , count , dp);
        return dp[n][k][count] = (end+move) % MOD ;
    }
}