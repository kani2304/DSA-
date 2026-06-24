class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        if (n == 1) {
            return r - l + 1;
        }

        int m = r - l + 1;
        int size = 2 * m;

        long[][] trans = new long[size][size];

        // up(x) -> down(y), y > x
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                trans[m + y][x] = 1;
            }
        }

        // down(x) -> up(y), y < x
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                trans[y][m + x] = 1;
            }
        }

        long[][] power = matrixPower(trans, n - 1);

        long[] startUp = new long[size];
        long[] startDown = new long[size];

        for (int i = 0; i < m; i++) {
            startUp[i] = 1;
            startDown[m + i] = 1;
        }

        long[] res1 = multiply(power, startUp);
        long[] res2 = multiply(power, startDown);

        long ans = 0;

        for (long val : res1) {
            ans = (ans + val) % MOD;
        }

        for (long val : res2) {
            ans = (ans + val) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }

            result[i] = sum;
        }

        return result;
    }

    private long[][] matrixPower(long[][] base, long exp) {
        int n = base.length;

        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return result;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;

        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    result[i][j] =
                        (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return result;
    }
}