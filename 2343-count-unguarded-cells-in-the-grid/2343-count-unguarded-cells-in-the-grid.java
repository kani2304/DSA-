class Solution {
    void markGuards(int r, int c, int grid[][]) {
       
        for (int i = r + 1; i < grid.length; i++) {
            if (grid[i][c] == 1 || grid[i][c] == 2)
                break;
            grid[i][c] = 3;
        }
    
        for (int i = r - 1; i >= 0; i--) {
            if (grid[i][c] == 1 || grid[i][c] == 2)
                break;
            grid[i][c] = 3;
        }
      
        for (int i = c + 1; i < grid[r].length; i++) {
            if (grid[r][i] == 1 || grid[r][i] == 2)
                break;
            grid[r][i] = 3;
        }
        
        for (int i = c - 1; i >= 0; i--) {
            if (grid[r][i] == 1 || grid[r][i] == 2)
                break;
            grid[r][i] = 3;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int cnt = 0;

        for (int i = 0; i < guards.length; i++) {
            grid[guards[i][0]][guards[i][1]] = 1;
        }

        for (int i = 0; i < walls.length; i++) {
            grid[walls[i][0]][walls[i][1]] = 2;
        }

        for (int i = 0; i < guards.length; i++) {
            markGuards(guards[i][0], guards[i][1], grid);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }
}