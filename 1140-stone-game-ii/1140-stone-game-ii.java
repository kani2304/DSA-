class Solution {
    private int[][] memo;
    private int[] suffix;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        memo = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return findBest(0, 1);
    }

    private int findBest(int index, int maxPiles) {
        if (index + 2 * maxPiles >= n) {
            return suffix[index];
        }

        if (memo[index][maxPiles] != 0) {
            return memo[index][maxPiles];
        }

        int best = 0;

        for (int piles = 1; piles <= 2 * maxPiles; piles++) {
            int opponent = findBest(
                index + piles,
                Math.max(maxPiles, piles)
            );

            best = Math.max(best, suffix[index] - opponent);
        }

        memo[index][maxPiles] = best;
        return best;
    }
}