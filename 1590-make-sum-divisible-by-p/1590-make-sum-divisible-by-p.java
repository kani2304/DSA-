class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int target = (int)(total % p);
        if (target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long cur = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            cur = (cur + nums[i]) % p;
            int need = (int)((cur - target + p) % p);

            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }

            map.put((int)cur, i);
        }

        return res == nums.length ? -1 : res;
    }
}