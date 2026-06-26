class Solution {
    private int[] bit;
    private int size;

    // Updates the Fenwick Tree by adding 'val' at index 'idx'
    private void update(int idx, int val) {
        for (; idx < size; idx += idx & -idx) {
            bit[idx] += val;
        }
    }

    // Returns the prefix sum (frequency count) up to index 'idx'
    private int query(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // Fenwick Tree size after shifting prefix sums by (n + 1)
        size = 2 * n + 2;
        bit = new int[size];

        long totalSubarrays = 0;
        int currentPrefixSum = 0;

        // Insert the initial prefix sum (0) into the Fenwick Tree
        update(n + 1, 1);

        for (int num : nums) {

            // Transform:
            // +1 -> target element
            // -1 -> any other element
            currentPrefixSum += (num == target) ? 1 : -1;

            // Shift index to handle negative prefix sums
            int shiftedIdx = currentPrefixSum + n + 1;

            // Count previous prefix sums that are strictly smaller
            // than the current prefix sum
            totalSubarrays += query(shiftedIdx - 1);

            // Store the current prefix sum for future subarrays
            update(shiftedIdx, 1);
        }

        return totalSubarrays;
    }
}