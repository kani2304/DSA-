
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0) + 1;
            freq.put(nums[right], count);

            // Shrink window if current element exceeds k frequency
            while (freq.get(nums[right]) > k) {
                int leftValue = nums[left];

                freq.put(leftValue, freq.get(leftValue) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}