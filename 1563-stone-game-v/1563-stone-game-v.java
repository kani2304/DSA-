class Solution {
    private int[] stoneValue;
    private int[] prefix;
    private Integer[][] memo;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        this.stoneValue = stoneValue;
        this.prefix = new int[n + 1];
        this.memo = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return dfs(0, n - 1);
    }

    private int dfs(int left, int right) {
        if (left >= right) {
            return 0;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int best = 0;

        for (int k = left; k < right; k++) {
            int leftSum = prefix[k + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[k + 1];

            if (leftSum < rightSum) {
                best = Math.max(
                    best,
                    leftSum + dfs(left, k)
                );
            } else if (leftSum > rightSum) {
                best = Math.max(
                    best,
                    rightSum + dfs(k + 1, right)
                );
            } else {
                best = Math.max(
                    best,
                    leftSum + dfs(left, k)
                );

                best = Math.max(
                    best,
                    rightSum + dfs(k + 1, right)
                );
            }
        }

        return memo[left][right] = best;
    }
}