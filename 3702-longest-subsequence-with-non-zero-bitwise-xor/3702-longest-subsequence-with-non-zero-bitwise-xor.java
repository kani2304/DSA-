
class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Entire array already has non-zero XOR.
        if (xor != 0) {
            return n;
        }

        // All elements are zero, so no valid subsequence exists.
        if (!hasNonZero) {
            return 0;
        }

        // Remove any non-zero element.
        return n - 1;
    }
}