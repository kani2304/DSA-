class Solution {

    static class Pair {
        long cnt;  
        long wav;  
        Pair(long cnt, long wav) {
            this.cnt = cnt;
            this.wav = wav;
        }
    }

    private String s;
    private Pair[][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 0) return 0;

        s = String.valueOf(x);

        memo = new Pair[s.length()][11][11][20];

        return dfs(0, 10, 10, 0, true).wav;
    }

    private Pair dfs(int pos, int prev2, int prev1,
                     int len, boolean tight) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (!tight && memo[pos][prev2][prev1][len] != null) {
            return memo[pos][prev2][prev1][len];
        }

        int limit = tight ? s.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWavy = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            int nPrev2 = prev2;
            int nPrev1 = prev1;
            int nLen = len;

            int add = 0;

            if (len == 0 && d == 0) {
                Pair child = dfs(pos + 1, 10, 10, 0, nextTight);

                totalCount += child.cnt;
                totalWavy += child.wav;
                continue;
            }

            if (len == 0) {
                nPrev1 = d;
                nLen = 1;
            } else if (len == 1) {
                nPrev2 = prev1;
                nPrev1 = d;
                nLen = 2;
            } else {

                if ((prev1 > prev2 && prev1 > d) ||
                    (prev1 < prev2 && prev1 < d)) {
                    add = 1;
                }

                nPrev2 = prev1;
                nPrev1 = d;
                nLen++;
            }

            Pair child = dfs(pos + 1, nPrev2, nPrev1,
                             Math.min(nLen, 19), nextTight);

            totalCount += child.cnt;

            totalWavy += child.wav + (long) add * child.cnt;
        }

        Pair ans = new Pair(totalCount, totalWavy);

        if (!tight) {
            memo[pos][prev2][prev1][len] = ans;
        }

        return ans;
    }
}