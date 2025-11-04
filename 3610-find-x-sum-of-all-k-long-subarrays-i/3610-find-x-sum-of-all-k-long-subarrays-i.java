class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] result = new int[nums.length - k + 1];
        int r = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 == k) {
                int tempResult = 0;
                List<Map.Entry<Integer, Integer>> pairs = new ArrayList<>(freq.entrySet());
                pairs.sort((p1, p2) -> {
                    if (!p1.getValue().equals(p2.getValue()))
                        return p2.getValue() - p1.getValue();
                    return p2.getKey() - p1.getKey();
                });

                for (int p = 0; p < x && p < pairs.size(); p++)
                    tempResult += (pairs.get(p).getKey() * pairs.get(p).getValue());

                result[r++] = tempResult;

                freq.put(nums[i], freq.get(nums[i]) - 1);
                if (freq.get(nums[i]) == 0)
                    freq.remove(nums[i]);
                i++;
            }
        }

        return result;
    }
}