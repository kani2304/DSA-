class Solution {
    Integer[] dp;
    private int solve(int i, int[] stoneValue) {
        if (i >= stoneValue.length) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int sum = 0;
        int best = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            sum += stoneValue[j];
            int difference = sum - solve(j + 1, stoneValue);
            best = Math.max(best, difference);
        }
        return dp[i] = best;
    }
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];
        int diff = solve(0, stoneValue);
        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        }
        return "Tie";
    }
}
