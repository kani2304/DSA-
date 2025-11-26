class Solution {
    public int numberOfPaths(int[][] grid, int k) {

        
        int MOD = 1_000_000_007 ;

        

        int rows = grid.length ;
        int cols = grid[0].length ;

        int[][][] dp = new int[rows + 1][cols + 1][k] ;

        dp[rows-1][cols-1][grid[rows-1][cols-1] % k] = 1;

        for(int row = rows - 1 ; row >= 0 ; row --)
        {
            for(int col = cols - 1 ; col >= 0 ; col --)
            {
                if(row == rows - 1 && col == cols - 1) continue ;

                for(int r = 0 ; r < k ; r ++)
                {
                    int x = (grid[row][col] + r) % k ;

                    int left = dp[row][col + 1][r] ;
                    int right = dp[row + 1][col][r] ;

                    dp[row][col][x] = (left + right) % MOD ;  
                }
            }
        }

        return dp[0][0][0] ;
        
    }
}