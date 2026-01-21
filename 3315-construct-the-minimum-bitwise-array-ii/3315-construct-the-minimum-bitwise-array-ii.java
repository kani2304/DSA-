class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int len = nums.size();
        int[] ans = new int[len];

        for(int i=0; i<len; i++) {
            int n = nums.get(i);

            if((n & 1) == 0) {
                ans[i] = -1;
            } else {
                int mask = 1;
                while((n & mask) != 0) {
                    mask <<= 1;
                }
                
                ans[i] = n - (mask >> 1);
            }
        }

        return ans;
    }
} 