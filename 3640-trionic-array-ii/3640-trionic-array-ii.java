class Solution {
    private static final long INF = (long) 1e18;

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return -1; 
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long[] dp3 = new long[n];
        
        // Initialize with -INF
        Arrays.fill(dp1, -INF);
        Arrays.fill(dp2, -INF);
        Arrays.fill(dp3, -INF);

        long maxEle = -INF;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
               
                dp1[i] = Math.max((long) nums[i] + nums[i - 1], dp1[i - 1] + nums[i]);

                if (dp2[i - 1] != -INF) {
                    dp3[i] = Math.max(dp3[i], dp2[i - 1] + nums[i]);
                }
                
                if (dp3[i - 1] != -INF) {
                    dp3[i] = Math.max(dp3[i], dp3[i - 1] + nums[i]);
                }
            } else if (nums[i] < nums[i - 1]) {
               
                if (dp1[i - 1] != -INF) {
                    dp2[i] = Math.max(dp2[i], dp1[i - 1] + nums[i]);
                }
               
                if (dp2[i - 1] != -INF) {
                    dp2[i] = Math.max(dp2[i], dp2[i - 1] + nums[i]);
                }
            }
       

            maxEle = Math.max(maxEle, dp3[i]);
        }

        return maxEle == -INF ? -1 : maxEle;
    }
}