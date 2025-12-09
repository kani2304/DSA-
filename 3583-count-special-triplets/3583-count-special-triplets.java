class Solution {
    public int specialTriplets(int[] nums) {
        long result = 0;
        int MOD = 1_000_000_007;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int num : nums)
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);

        for (int i = 0; i < nums.length; i++) {
            rightMap.put(nums[i], rightMap.get(nums[i]) - 1);
            if (rightMap.get(nums[i]) == 0)
                rightMap.remove(nums[i]);

            int dbl = nums[i] * 2;

            if (leftMap.containsKey(dbl) && rightMap.containsKey(dbl))
                result = (result + (1l * leftMap.get(dbl) * rightMap.get(dbl)) % MOD) % MOD;

            leftMap.put(nums[i], leftMap.getOrDefault(nums[i], 0) + 1);
        }

        return (int) result;
    }
}