class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int c = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i : nums){
            c = (c * 2 + i) % 5;
            res.add(c == 0);
        }
        return res;
    }
}