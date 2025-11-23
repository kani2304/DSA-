
class Solution {
    public int maxSumDivThree(int[] nums) {
        long neginfi = (long)-1e18;

        long[] dp = new long[]{0, neginfi, neginfi};

        for (int x : nums) {
            long[] next = dp.clone();
            int add = x % 3;

            for (int r = 0; r < 3; r++) {
                if (dp[r] == neginfi) continue;

                int nr = (r + add) % 3;
                long candidate = dp[r] + x;

                if (candidate > next[nr]) {
                    next[nr] = candidate;
                }
            }

            dp = next;
        }

        return (int)Math.max(0, dp[0]);
    }
}