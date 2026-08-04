class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            }

            minNum = Math.min(minNum, i);
            maxNum = Math.max(maxNum, i);
        }

        for (int i = minNum + 1; i < maxNum; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}