import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int sr = 0;
        int sc = 0;
        int cnt = 0;

        // id[i][j] stores the unique ID of litter at (i, j)
        int[][] id = new int[n][m];

        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        // Find the starting position and number the litter cells
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                char ch = classroom[i].charAt(j);

                // Store starting position
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                // Give every litter cell a unique ID
                if (ch == 'L') {
                    id[i][j] = cnt++;
                }
            }
        }

        /*
         * best[r][c][mask] =
         * maximum remaining energy with which
         * we have reached (r, c) after collecting
         * the litter represented by mask.
         */
        int[][][] best = new int[n][m][1 << cnt];

        // Initially, no state has been visited
        for (int[][] a : best) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        /*
         * Queue state:
         *
         * [row, column, energy, mask, moves]
         */
        Queue<int[]> q = new ArrayDeque<>();

        // Start from S
        q.offer(new int[]{sr, sc, energy, 0, 0});

        // At the starting position, we have full energy
        best[sr][sc][0] = energy;

        // Four possible directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Mask when all litter has been collected
        int all = (1 << cnt) - 1;

        // BFS
        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];

            // All litter collected
            if (mask == all) {
                return moves;
            }

            // No energy left, so we cannot move
            if (e == 0) {
                continue;
            }

            // Try all four directions
            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                // Check boundaries
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                char ch = classroom[nr].charAt(nc);

                // Cannot move through blocked cells
                if (ch == 'X') {
                    continue;
                }

                // Moving costs one unit of energy
                int ne = e - 1;

                // Initially keep the same litter mask
                int nm = mask;

                // Collect litter
                if (ch == 'L') {
                    nm |= 1 << id[nr][nc];
                }

                // Recharge energy
                if (ch == 'R') {
                    ne = energy;
                }

                /*
                 * If we have already reached the same
                 * position and mask with more energy,
                 * this state is not useful.
                 */
                if (best[nr][nc][nm] >= ne) {
                    continue;
                }

                // Save the best remaining energy
                best[nr][nc][nm] = ne;

                // Add new state to BFS
                q.offer(new int[]{
                    nr,
                    nc,
                    ne,
                    nm,
                    moves + 1
                });
            }
        }

        // Impossible to collect all litter
        return -1;
    }
}