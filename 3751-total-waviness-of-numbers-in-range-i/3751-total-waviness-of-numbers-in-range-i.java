class Solution {
    static final int le = 100010;
    static int[] dp = new int[le];
    static boolean flag = false;

    public int totalWaviness(int num1, int num2) {
        if (!flag) {
            countWaves();
            flag = true;
        }

        return dp[num2] - dp[num1 - 1];
    }

    void countWaves() {
        int[] d;

        for (int b = 101; b < le; b++) {
            int a = b;

            int l = (int) Math.log10(a) + 1;

            d = new int[l];

            for (int i = l - 1; i >= 0; i--) {
                d[i] = a % 10;
                a /= 10;
            }

            int ans = 0;

            for (int i = 1; i < l - 1; i++) {
                if ((d[i - 1] < d[i] && d[i + 1] < d[i]) ||
                    (d[i - 1] > d[i] && d[i + 1] > d[i])) {
                    ans++;
                }
            }

            dp[b] = dp[b - 1] + ans;
        }
    }
}