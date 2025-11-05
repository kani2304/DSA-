class Solution {
    private static long pack(long cnt, long value) {
        return (cnt << 32) | value;
    }

    private static long multiply(long cv) {
        if (cv == Long.MAX_VALUE) {
            return 0;
        }
        long cnt = cv >> 32, value = cv & 0xFF_FF_FF_FFL;
        return cnt * value;
    }

    private static void update(Map<Integer, Integer> cnts, TreeSet<Long> cvs, long[] xsum, long[] mincv, int x,
                               int v, int d) {
        int pcnt = cnts.getOrDefault(v, 0);
        if (pcnt > 0) {
            long cv = pack(pcnt, v);
            cvs.remove(cv);
            if (cv >= mincv[0]) {
                xsum[0] -= multiply(cv);
                Long pmincv = cvs.lower(mincv[0]);
                if (pmincv != null) {
                    xsum[0] += multiply(pmincv);
                    mincv[0] = pmincv;
                } else if (cv == mincv[0]) {
                    mincv[0] = (cvs.isEmpty() ? Long.MAX_VALUE : cvs.higher(mincv[0]));
                }
            }
        }
        int ncnt = pcnt + d;
        cnts.put(v, ncnt);
        if (ncnt > 0) {
            long cv = pack(ncnt, v);
            cvs.add(cv);
            if (cv >= mincv[0]) {
                xsum[0] += multiply(cv);
                if (cvs.size() > x) {
                    xsum[0] -= multiply(mincv[0]);
                    mincv[0] = cvs.higher(mincv[0]);
                }
            } else if (cvs.size() <= x) {
                xsum[0] += multiply(cv);
                mincv[0] = cv;
            }
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            cnts.merge(nums[i], 1, (a, b) -> a + b);
        }
        TreeSet<Long> cvs = new TreeSet<>();
        for (var entry : cnts.entrySet()) {
            int value = entry.getKey(), cnt = entry.getValue();
            cvs.add(pack(cnt, value));
        }
        long[] xsum = {0}, mincv = {Long.MAX_VALUE};
        int cnt = 0;
        for (long cv : cvs.descendingSet()) {
            ++cnt;
            if (cnt > x) {
                break;
            }
            mincv[0] = cv;
            xsum[0] += multiply(cv);
        }
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        ans[0] = xsum[0];
        for (int i = 1; i < n - k + 1; ++i) {
            update(cnts, cvs, xsum, mincv, x, nums[i - 1], -1);
            update(cnts, cvs, xsum, mincv, x, nums[i + k - 1], 1);
            ans[i] = xsum[0];
        }
        return ans;
    }
}